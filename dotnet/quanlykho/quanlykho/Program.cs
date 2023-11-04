using quanlykho.Utility;
using System.Data.SqlTypes;

namespace quanlykho
{
    internal static class Program
    {
        /// <summary>
        ///  The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            DBhelper.serverName = "-PC\\SQLEXPRESS";
            DBhelper.databaseName = "test";
            DBhelper.userID = "huy";
            DBhelper.password = "123";
            // To customize application configuration such as set high DPI settings or default font,
            // see https://aka.ms/applicationconfiguration.
            ApplicationConfiguration.Initialize();
            Application.Run(new MDI());
        }
    }
}