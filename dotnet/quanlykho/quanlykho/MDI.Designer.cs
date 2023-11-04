namespace quanlykho
{
    partial class MDI
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            menuStrip1 = new MenuStrip();
            danhMucToolStripMenuItem = new ToolStripMenuItem();
            menuKho = new ToolStripMenuItem();
            menuHanghoa = new ToolStripMenuItem();
            nhậpXuấtToolStripMenuItem = new ToolStripMenuItem();
            menuPhieunhapkho = new ToolStripMenuItem();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.ImageScalingSize = new Size(20, 20);
            menuStrip1.Items.AddRange(new ToolStripItem[] { danhMucToolStripMenuItem, nhậpXuấtToolStripMenuItem });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new Size(731, 28);
            menuStrip1.TabIndex = 1;
            menuStrip1.Text = "menuStrip1";
            // 
            // danhMucToolStripMenuItem
            // 
            danhMucToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { menuKho, menuHanghoa });
            danhMucToolStripMenuItem.Name = "danhMucToolStripMenuItem";
            danhMucToolStripMenuItem.Size = new Size(90, 24);
            danhMucToolStripMenuItem.Text = "Danh mục";
            // 
            // menuKho
            // 
            menuKho.Name = "menuKho";
            menuKho.Size = new Size(224, 26);
            menuKho.Text = "Kho";
            menuKho.Click += menuKho_Click;
            // 
            // menuHanghoa
            // 
            menuHanghoa.Name = "menuHanghoa";
            menuHanghoa.Size = new Size(224, 26);
            menuHanghoa.Text = "Hàng hóa";
            menuHanghoa.Click += menuHanghoa_Click;
            // 
            // nhậpXuấtToolStripMenuItem
            // 
            nhậpXuấtToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { menuPhieunhapkho });
            nhậpXuấtToolStripMenuItem.Name = "nhậpXuấtToolStripMenuItem";
            nhậpXuấtToolStripMenuItem.Size = new Size(95, 24);
            nhậpXuấtToolStripMenuItem.Text = "Nhập/Xuất";
            // 
            // menuPhieunhapkho
            // 
            menuPhieunhapkho.Name = "menuPhieunhapkho";
            menuPhieunhapkho.Size = new Size(224, 26);
            menuPhieunhapkho.Text = "Nhập kho";
            menuPhieunhapkho.Click += menuPhieunhapkho_Click;
            // 
            // MDI
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(731, 544);
            Controls.Add(menuStrip1);
            IsMdiContainer = true;
            MainMenuStrip = menuStrip1;
            Name = "MDI";
            Text = "Trang chủ";
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private MenuStrip menuStrip1;
        private ToolStripMenuItem danhMucToolStripMenuItem;
        private ToolStripMenuItem menuKho;
        private ToolStripMenuItem menuHanghoa;
        private ToolStripMenuItem nhậpXuấtToolStripMenuItem;
        private ToolStripMenuItem menuPhieunhapkho;
    }
}