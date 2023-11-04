using quanlykho.Model;
using quanlykho.Utility;
using quanlykho.View;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace quanlykho.Controller
{
    internal class DanhmuckhoController
    {
        List<Danhmuckho> khoList;
        public DanhmuckhoController()
        {
            
        }
        public List<Danhmuckho> load()
        {
            khoList = new List<Danhmuckho>();
            SqlConnection conn = DBhelper.getConnection();
            try
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("select * from Danhmuckho", conn);
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    String ID = reader["Makho"].ToString();
                    String Tenkho = reader["Tenkho"].ToString();
                    String Diachikho = reader["Diachikho"].ToString();
                    Danhmuckho kho = new Danhmuckho(ID, Tenkho, Diachikho);
                    khoList.Add(kho);
                }
            }
            catch (SqlException ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally { conn.Close(); }
            
            return khoList;
        }
        public void insert(Danhmuckho kho)
        {
            
            SqlConnection conn = DBhelper.getConnection();
            try
            {
                conn.Open();
                string sql = "Insert into Danhmuckho (Makho, Tenkho, Diachikho) values ('" + kho.getId() + "', '" + kho.getTenkho() + "', '" + kho.getDiachikho() + "')";
                SqlCommand cmd = new SqlCommand(sql, conn);

                //string sql = "INSERT INTO Danhmuckho (Makho, Tenkho, Diachikho) VALUES (@Makho, @Tenkho, @Diachikho)";
                //SqlCommand cmd = new SqlCommand(sql, conn);
                //cmd.Parameters.AddWithValue("@Makho", kho.getId());
                //cmd.Parameters.AddWithValue("@Tenkho", kho.getTenkho());
                //cmd.Parameters.AddWithValue("@Diachikho", kho.getDiachikho());

                cmd.ExecuteNonQuery();
            }
            catch (SqlException ex) { Console.WriteLine(ex.Message); }
            finally { conn.Close(); }
            
        }
        public void edit(Danhmuckho kho)
        {
            SqlConnection conn = DBhelper.getConnection();
            try
            {
                conn.Open();
                string sql = "Update Danhmuckho set Tenkho = '" + kho.getTenkho() + "', Diachikho = '" + kho.getDiachikho() + "' where Makho = '" + kho.getId() + "'";
                
                SqlCommand cmd = new SqlCommand(sql, conn);
                cmd.ExecuteNonQuery();
            }
            catch (SqlException ex) { Console.WriteLine(); }
            finally { conn.Close(); }
        }
        public void delete(Danhmuckho kho)
        {
            SqlConnection conn = DBhelper.getConnection();
            try
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand("Delete from Danhmuckho where Makho = '" + kho.getId() + "'", conn);
                cmd.ExecuteNonQuery();
            }
            catch (SqlException ex) { Console.WriteLine(); }
            finally { conn.Close(); }
        }
        public List<Danhmuckho> search(Danhmuckho kho)
        {
            khoList = new List<Danhmuckho>();
            SqlConnection conn = DBhelper.getConnection();
            try
            {
                conn.Open();
                string search = "Select * from Danhmuckho where Makho = '" + kho.getId() + "'";
                SqlCommand cmd = new SqlCommand(search, conn);
                SqlDataReader reader = cmd.ExecuteReader();
                while(reader.Read())
                {
                    String ID = reader["Makho"].ToString();
                    String Tenkho = reader["Tenkho"].ToString();
                    String Diachikho = reader["Diachikho"].ToString();
                    Danhmuckho item = new Danhmuckho(ID, Tenkho, Diachikho);
                    khoList.Add(item);
                }
            }
            catch { Console.WriteLine(); }
            finally { conn.Close(); }
            return khoList;
        }
    }
}


