import pandas as pd
import matplotlib.pyplot as plt


# set độ dài hiển thị
pd.set_option('display.width', 450)
pd.set_option('display.max_columns', 50)


# đường dẫn của dữ liệu
path = 'C:/GiuaKy/sales_data_sample.csv' # NOQA
df = pd.read_csv(path, encoding='latin1')


# tạo thêm 1 cột year trong dataframe
years = lambda years: years.split('/')[2] # NOQA
nam = df['ORDERDATE'].apply(years) # NOQA
df['YEAR'] = nam.str[0:4]


# tạo thêm 1 cột date trong dataframe
dates = lambda dates: dates.split('/')[0] # NOQA
df['DATES'] = df['ORDERDATE'].apply(dates) # NOQA


# chuyển cột "date" qua kế cột "orderdate" để dễ quan sát
moving_column = df.pop('DATES')
df.insert(6, 'DATES', moving_column)


# xóa các cột nếu 1 trong các giá trị của cột đó là NaN
df = df.dropna(axis='columns')

print(df)


# chuyển dataframe vào 1 file csv trong thư mục của file code
# df.to_csv('sales_data_sample_edited_on_pycharm.csv', index=False) # NOQA


# tính doanh số bán hàng theo năm
years = df['YEAR'].unique()
sales_value = df.groupby('YEAR').sum()['SALES']

# plot biểu đồ
plt.bar(x=years, height=sales_value)
plt.xlabel('Năm')
plt.ylabel('Doanh số')
plt.title('Doanh số bán hàng theo năm')
plt.show()


# tính số lượng sp bán ra theo tháng
months = range(1,13)
quantity_value = df.groupby('MONTH_ID').sum()['QUANTITYORDERED'] # NOQA

# # plot biểu đồ đường
plt.plot(months, quantity_value)
plt.grid()
plt.xticks(months)
plt.title('Biểu đồ số lượng SP bán ra theo tháng')
plt.xlabel('Tháng')
plt.ylabel('Số lượng SP bán ra')
plt.show()


# Biểu đồ kết hợp thể hiện theo sản phẩm
price = df.groupby('PRODUCTLINE').mean()['PRICEEACH'] # NOQA
all_products = df.groupby('PRODUCTLINE').sum()['QUANTITYORDERED'] # NOQA
products = [product for product, quant in all_products.items()]

# plot biểu đồ
x = products
y1 = all_products
y2 = price
fig, ax1 = plt.subplots()
ax2 = ax1.twinx()

ax1.bar(x, y1, color='g')
ax2.plot(x, y2, 'b-')

ax1.set_xticklabels(products, rotation=20, size=7)
plt.title('Biểu đồ doanh số theo từng loại sản phẩm') # NOQA
ax1.set_xlabel('Sản phẩm') # NOQA
ax1.set_ylabel('Số lượng') # NOQA
ax2.set_ylabel('Giá')
plt.show()
