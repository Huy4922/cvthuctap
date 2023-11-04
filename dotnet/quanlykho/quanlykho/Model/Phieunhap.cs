using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace quanlykho.Model
{
    internal class Phieunhap
    {
        public string Id;
        public string Ngaynhapkho;
        public string Nguoigiaohang;
        public string Sohoadon;
        public string Ngayhoadon;
        public string DonviphathanhHD;
        public Hanghoa hanghoa;
        public Phieunhap() { }
        public Phieunhap(string id, string ngaynhapkho, string nguoigiaohang, string sohoadon, string ngayhoadon, string donviphathanhHD, string mahh)
        {
            hanghoa = new Hanghoa();
            Id = id;
            Ngaynhapkho = ngaynhapkho;
            Nguoigiaohang = nguoigiaohang;
            Sohoadon = sohoadon;
            Ngayhoadon = ngayhoadon;
            DonviphathanhHD = donviphathanhHD;
            hanghoa.Id = mahh;
        }
        public string getId()
        {
            return Id;
        }
        public void setId(string id)
        {
            this.Id = id;
        }
        public string getNgaynhapkho()
        {
            return this.Ngaynhapkho;
        }
        public void setNgaynhapkho(string ngaynhapkho)
        {
            this.Ngaynhapkho = ngaynhapkho;
        }
        public string setNguoigiaohang()
        {
            return Nguoigiaohang;
        }
        public void getNguoigiaohang(string nguoigiaohang)
        {
            this.Nguoigiaohang = nguoigiaohang;
        }
        public string setSohoadon()
        {
            return Sohoadon;
        }
        public void getSohoadon(string sohoadon)
        {
            this.Sohoadon = sohoadon;
        }
        public string setNgayhoadon()
        {
            return Ngayhoadon;
        }
        public void getNgayhoadon(string ngayhoadon)
        {
            this.Ngayhoadon = ngayhoadon;
        }
        public string setDonviphathanhHD()
        {
            return DonviphathanhHD;
        }
        public void getDonviphathanhHD(string donviphathanhHD)
        {
            this.DonviphathanhHD = donviphathanhHD;
        }
        public string setMahh()
        {
            return hanghoa.Id;
        }
        public void getMahh(string mahh)
        {
            hanghoa.Id= mahh;
        }
    }
}
