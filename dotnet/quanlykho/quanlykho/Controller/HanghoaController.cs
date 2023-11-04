using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using quanlykho.Model;
using quanlykho.Utility;

namespace quanlykho.Controller
{
    internal class HanghoaController
    {
        List<Hanghoa> hanghoaList;
        public HanghoaController() { }
        public List<Hanghoa> load() 
        {
            hanghoaList = new List<Hanghoa>();
            SqlConnection conn = DBhelper.getConnection();
            try
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("select * from Hanghoa", conn);
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    String ID = reader["MaHH"].ToString();
                    String Tenhang = reader["Tenhang"].ToString();
                    String Soluong = reader["Soluong"].ToString();
                    String Dongia = reader["Dongia"].ToString();
                    Hanghoa hanghoa = new Hanghoa(ID, Tenhang, Soluong, Dongia);
                    hanghoaList.Add(hanghoa);
                }
            }
            catch (Exception ex) { Console.WriteLine(ex.Message); }
            finally { conn.Close(); }
            return hanghoaList; 
        }
        public void insert(Hanghoa hang)
        {
            SqlConnection conn = DBhelper.getConnection();
            try
            {
                conn.Open();
                string sql = "Insert into Hanghoa (MaHH, Tenhang, Soluong, Dongia) values ('" + hang.getId() + "', '" + hang.getTenhang() + "', '" + hang.getSoluong() + "', ' " + hang.getDongia() + "')";
                SqlCommand cmd = new SqlCommand(sql, conn);
                cmd.ExecuteNonQuery();
            }
            catch (SqlException ex) { Console.WriteLine(ex.Message); }
            finally { conn.Close(); }

        }
    }
}
