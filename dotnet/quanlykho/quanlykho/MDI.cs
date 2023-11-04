namespace quanlykho
{
    public partial class MDI : Form
    {
        public MDI()
        {
            InitializeComponent();
        }

        private void menuKho_Click(object sender, EventArgs e)
        {
            View.frmDanhmuckho frmDanhmuckho1 = new View.frmDanhmuckho();
            frmDanhmuckho1.btnTai_Click(sender, e);
            frmDanhmuckho1.ShowDialog();
        }

        private void menuHanghoa_Click(object sender, EventArgs e)
        {
            View.frmHanghoa frmHanghoa1 = new View.frmHanghoa();
            frmHanghoa1.btnTai_Click(sender, e);
            frmHanghoa1.ShowDialog();
        }

        private void menuPhieunhapkho_Click(object sender, EventArgs e)
        {
            View.frmPhieunhapkho frmPhieunhapkho = new View.frmPhieunhapkho();
            frmPhieunhapkho.ShowDialog();
        }
    }
}