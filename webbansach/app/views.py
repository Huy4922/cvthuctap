from django.http import HttpResponse, JsonResponse
from django.shortcuts import render, redirect
from .models import *
import json
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages

def detail(request):
    if request.user.is_authenticated:
        customer = request.user
        order, created = Order.objects.get_or_create(customer = customer,complete =False)
        items = order.orderitem_set.all()
        cartItems = order.get_cart_items
        user_not_login = "hidden"
        user_login = "show"
    else:
        items=[]
        order= {'get_cart_items':0,'get_cart_total':0}
        cartItems = order['get_cart_items']
        user_not_login = "show"
        user_login = "hidden"
    id = request.GET.get('id','')
    products = Product.objects.filter(id=id)
    categories = Category.objects.filter(is_sub = False)
    context={'products':products,'categories':categories,'items':items,'order':order,'cartItems':cartItems,'user_not_login':user_not_login,'user_login':user_login}
    return render(request,'app/detail.html',context)

def category(request):
    categories = Category.objects.filter(is_sub = False)
    active_category = request.GET.get('category','')
    cartItems = 0
    if active_category:
        products = Product.objects.filter(category__slug = active_category)   
    if request.user.is_authenticated:
        customer = request.user
        order, created = Order.objects.get_or_create(customer = customer,complete =False)
        items = order.orderitem_set.all()
        cartItems = order.get_cart_items
        user_not_login = "hidden"
        user_login = "show"
    else:
        user_not_login = "show"
        user_login = "hidden"
   
    context = {'products':products,'cartItems':cartItems,'user_not_login':user_not_login,'user_login':user_login,'categories':categories,'active_category':active_category}
    return render(request,'app/category.html',context)
def register(request):
    categories = Category.objects.filter(is_sub = False)
    form = CreateUserForm()
    if request.method == "POST":
        form = CreateUserForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('login')
    context={'form':form, 'categories':categories}
    return render(request, 'app/register.html', context)

def search(request):
    if request.method == "POST":
        searched = request.POST["searched"]
        keys = Product.objects.filter(name__contains = searched)
    if request.user.is_authenticated: #khi user dang nhap roi
        customer = request.user
        order, created = Order.objects.get_or_create(customer = customer, complete = False)
        items = order.orderitem_set.all()
        cartItems = order.get_cart_items
        user_not_login = "hidden"
        user_login = "show"
    else:
        items = []
        order = {'get_cart_items':0, 'get_cart_total':0}
        cartItems = order['get_cart_items']
        user_not_login = "show"
        user_login = "hidden"
    categories = Category.objects.filter(is_sub = False)
    products = Product.objects.all()
    return render(request, 'app/search.html', {"searched": searched, "keys":keys, 'products': products, 'cartItems':cartItems, 'user_not_login':user_not_login,'user_login':user_login})
    
def loginPage(request):
    categories = Category.objects.filter(is_sub = False)
    if request.user.is_authenticated:
        return redirect('home')
    if request.method == "POST":
        username = request.POST.get('username')
        password = request.POST.get('password')
        user = authenticate(request, username = username, password = password)
        if user is not None:
            login(request, user)
            return redirect('home')
        else:
            messages.info(request, 'Tên đăng nhập hoặc mật khẩu không đúng.')
    context={'categories':categories}
    return render(request, 'app/login.html', context)

def logoutPage(request):
    logout(request)
    return redirect('login')


def home(request):
    if request.user.is_authenticated: #khi user dang nhap roi
        customer = request.user
        order, created = Order.objects.get_or_create(customer = customer, complete = False)
        items = order.orderitem_set.all()
        cartItems = order.get_cart_items
        user_not_login = "hidden"
        user_login = "show"
    else:
        items = []
        order = {'get_cart_items':0, 'get_cart_total':0}
        cartItems = order['get_cart_items']
        user_not_login = "show"
        user_login = "hidden"
    categories = Category.objects.filter(is_sub = False)
    active_category = request.GET.get('category','')
    products = Product.objects.all()
    search_price = request.GET.get('search_price')
    if search_price == 'asc':
        products = Product.objects.all().order_by('price')  # Sắp xếp theo giá tăng dần
    elif search_price == 'desc':
        products = Product.objects.all().order_by('-price')  # Sắp xếp theo giá giảm dần
    context= {'categories':categories, 'products': products, 'cartItems':cartItems, 'active_category':active_category, 'user_not_login':user_not_login, 'user_login':user_login}
    return render(request, 'app/home.html', context)
def cart(request):
    if request.user.is_authenticated: #khi user dang nhap roi
        customer = request.user
        order, created = Order.objects.get_or_create(customer = customer, complete = False)
        items = order.orderitem_set.all()
        cartItems = order.get_cart_items
    else:
        items = []
        order = {'get_cart_items':0, 'get_cart_total':0}
        cartItems = order['get_cart_items']
    categories = Category.objects.filter(is_sub = False)
    context={'items':items, 'order': order, 'cartItems':cartItems, 'categories':categories}
    return render(request, 'app/cart.html', context)
def checkout(request):
    if request.user.is_authenticated: #khi user dang nhap roi
        customer = request.user
        order, created = Order.objects.get_or_create(customer = customer, complete = False)
        items = order.orderitem_set.all()
        cartItems = order.get_cart_items
    else:
        items = []
        order = {'get_cart_items':0, 'get_cart_total':0}
        cartItems = order['get_cart_items']
    categories = Category.objects.filter(is_sub = False)
    context={'items':items, 'order': order, 'cartItems':cartItems, 'categories':categories}
    return render(request, 'app/checkout.html', context)  

def updateItem(request):
    data = json.loads(request.body)
    productId = data['productId']
    action = data['action']
    customer = request.user
    product = Product.objects.get(id = productId)
    order, created = Order.objects.get_or_create(customer = customer, complete = False)
    orderItem, created = OrderItem.objects.get_or_create(order = order, product = product)
    if action == 'add':
        orderItem.quantity+=1
    elif action == 'remove':
        orderItem.quantity-=1
    orderItem.save()
    if orderItem.quantity<=0:
        orderItem.delete()

    return JsonResponse('added', safe=False)

def shipping_address_view(request):
    if request.method == 'POST':
        # Lấy dữ liệu từ form
        address = request.POST.get('address')
        city = request.POST.get('city')
        state = request.POST.get('state')
        mobile = request.POST.get('mobile')
        
        # Lưu thông tin địa chỉ giao hàng vào cơ sở dữ liệu
        if request.user.is_authenticated:
            customer = request.user
            order, created = Order.objects.get_or_create(customer=customer, complete=False)
            shipping_address, created = ShippingAddress.objects.get_or_create(order=order, defaults={
                'customer': customer,
                'address': address,
                'city': city,
                'state': state,
                'mobile': mobile
            })

            # Đánh dấu đơn hàng là đã hoàn thành hoặc xóa đơn hàng nếu đã hoàn thành
            order.complete = True  # Đánh dấu đơn hàng đã hoàn thành
            order.save()
            # Thực hiện các hành động khác sau khi đã lưu thông tin địa chỉ giao hàng
            # Ví dụ: Chuyển hướng đến trang tiếp theo sau khi nhập thông tin thành công
            
            return redirect('checkout')  # Chuyển hướng đến trang thanh toán sau khi nhập địa chỉ giao hàng
        
    return render(request, 'app/home.html')