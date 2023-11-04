using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace quanlykho.Model
{
    internal class Hanghoa
    {
        public string Id;
        public string Tenhang;
        public string Soluong;
        public string Dongia;
        public Hanghoa() { }
        public Hanghoa(string id, string tenhang, string soluong, string dongia)
        {
            Id = id;
            Tenhang = tenhang;
            Soluong = soluong;
            Dongia = dongia;
        }
        public string getId()
        {
            return Id;
        }
        public void setId(string id) { this.Id = id;}
        public string getSoluong() {  return Soluong;}
        public void setSoluong(string soluong)
        {
            this.Soluong = soluong;
        }
        public void setTenhang(string tenhang)
        {
            this.Tenhang = tenhang;
        }
        public string getTenhang() { return Tenhang; }
        public string getDongia() { return Dongia;}
        public void setDongia(string dongia)
        {
            this.Dongia = dongia;
        }
    }
}
