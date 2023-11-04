using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using quanlykho.Utility;
using quanlykho.Controller;

namespace quanlykho.Model
{
    internal class Danhmuckho
    {
        public string Id;
        public string Tenkho;
        public string Diachikho;
        public Danhmuckho()
        {

        }
        public Danhmuckho(String id, String tenkho, String diachikho)
        {
            this.Id = id;
            this.Tenkho = tenkho;
            this.Diachikho = diachikho;
        }
        public string getId()
        {
            return Id;
        }
        public string getTenkho()
        {
            return Tenkho;
        }
        public string getDiachikho()
        {
            return Diachikho;
        }
        public void setId(string id)
        {
            this.Id = id;
        }
        public void setTenkho(string tenkho)
        {
            this.Tenkho = tenkho;
        }
        public void setDiachikho(string diachikho)
        {
            this.Diachikho= diachikho;
        }
    }
}
