using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace quanlykho.Model
{
    internal class CTPhieuNhap
    {
        public string Id;
        public string Soluong;
        public string Dongia;
        
        public Hanghoa hanghoa;
        public Phieunhap phieunhap;
        public CTPhieuNhap() { }
        public CTPhieuNhap(string id, string soluong, string dongia, string maphieunhap, string mahh)
        {
            hanghoa = new Hanghoa();
            phieunhap = new Phieunhap();
            Id = id;
            hanghoa.Soluong = soluong;
            hanghoa.Dongia = dongia;
            phieunhap.Id = maphieunhap;
            hanghoa.Id = mahh;
        }
        public void setId(string id) { this.Id = id; }
        public string getId() { return this.Id;}
        public void setSoluong(string soluong)
        {
            this.Soluong = soluong;
        }
        public string getSoluong()
        {
            return hanghoa.Soluong;
        }
        public void setDongia(string dongia)
        {
            this.Dongia = dongia;
        }
        public string getDongia()
        {
            return hanghoa.Dongia;
        }
        public void setMaphieunhap(string maphieunhap)
        {
            phieunhap.Id = maphieunhap;
        }
        public string getMaphieunhap()
        {
            return phieunhap.Id;
        }
        public void setMahh(string mahh)
        {
            hanghoa.Id = mahh;
        }
        public string getMahh() { return hanghoa.Id; }
    }
    
}
