from django.contrib import admin
from django.urls import path, include
#load image
from django.conf.urls.static import static #static la tai nguyen
from django.conf import settings

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('app.urls')),
]
urlpatterns += static(settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)