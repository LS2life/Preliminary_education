namespace ParkingManager
{
    partial class MainForm
    {
        /// <summary>
        /// 필수 디자이너 변수입니다.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 사용 중인 모든 리소스를 정리합니다.
        /// </summary>
        /// <param name="disposing">관리되는 리소스를 삭제해야 하면 true이고, 그렇지 않으면 false입니다.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form 디자이너에서 생성한 코드

        /// <summary>
        /// 디자이너 지원에 필요한 메서드입니다. 
        /// 이 메서드의 내용을 코드 편집기로 수정하지 마세요.
        /// </summary>
        private void InitializeComponent()
        {
			this.components = new System.ComponentModel.Container();
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainForm));
			this.groupBox1 = new System.Windows.Forms.GroupBox();
			this.button_remove = new System.Windows.Forms.Button();
			this.button_parking = new System.Windows.Forms.Button();
			this.textBox_phoneNumber = new System.Windows.Forms.TextBox();
			this.textBox_driverName = new System.Windows.Forms.TextBox();
			this.textBox_carNumber = new System.Windows.Forms.TextBox();
			this.textBox_parkingSpot = new System.Windows.Forms.TextBox();
			this.label5 = new System.Windows.Forms.Label();
			this.label4 = new System.Windows.Forms.Label();
			this.label3 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.groupBox2 = new System.Windows.Forms.GroupBox();
			this.button_refresh = new System.Windows.Forms.Button();
			this.button_delete = new System.Windows.Forms.Button();
			this.button_add = new System.Windows.Forms.Button();
			this.button_find = new System.Windows.Forms.Button();
			this.textBox_findNum = new System.Windows.Forms.TextBox();
			this.label6 = new System.Windows.Forms.Label();
			this.groupBox3 = new System.Windows.Forms.GroupBox();
			this.dataGridView_parkingManager = new System.Windows.Forms.DataGridView();
			this.관리내역 = new System.Windows.Forms.ListBox();
			this.label_now = new System.Windows.Forms.Label();
			this.timer_now = new System.Windows.Forms.Timer(this.components);
			this.groupBox4 = new System.Windows.Forms.GroupBox();
			this.label9 = new System.Windows.Forms.Label();
			this.label8 = new System.Windows.Forms.Label();
			this.label7 = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.groupBox1.SuspendLayout();
			this.groupBox2.SuspendLayout();
			this.groupBox3.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.dataGridView_parkingManager)).BeginInit();
			this.groupBox4.SuspendLayout();
			this.SuspendLayout();
			// 
			// groupBox1
			// 
			this.groupBox1.BackColor = System.Drawing.Color.Lavender;
			this.groupBox1.Controls.Add(this.button_remove);
			this.groupBox1.Controls.Add(this.button_parking);
			this.groupBox1.Controls.Add(this.textBox_phoneNumber);
			this.groupBox1.Controls.Add(this.textBox_driverName);
			this.groupBox1.Controls.Add(this.textBox_carNumber);
			this.groupBox1.Controls.Add(this.textBox_parkingSpot);
			this.groupBox1.Controls.Add(this.label5);
			this.groupBox1.Controls.Add(this.label4);
			this.groupBox1.Controls.Add(this.label3);
			this.groupBox1.Controls.Add(this.label2);
			this.groupBox1.Location = new System.Drawing.Point(164, 14);
			this.groupBox1.Name = "groupBox1";
			this.groupBox1.Size = new System.Drawing.Size(282, 149);
			this.groupBox1.TabIndex = 0;
			this.groupBox1.TabStop = false;
			this.groupBox1.Text = "주차/출차";
			// 
			// button_remove
			// 
			this.button_remove.BackColor = System.Drawing.Color.Red;
			this.button_remove.Location = new System.Drawing.Point(188, 48);
			this.button_remove.Name = "button_remove";
			this.button_remove.Size = new System.Drawing.Size(75, 23);
			this.button_remove.TabIndex = 9;
			this.button_remove.Text = "출차";
			this.button_remove.UseVisualStyleBackColor = false;
			this.button_remove.Click += new System.EventHandler(this.button_remove_Click);
			// 
			// button_parking
			// 
			this.button_parking.BackColor = System.Drawing.Color.Blue;
			this.button_parking.Location = new System.Drawing.Point(188, 17);
			this.button_parking.Name = "button_parking";
			this.button_parking.Size = new System.Drawing.Size(75, 23);
			this.button_parking.TabIndex = 8;
			this.button_parking.Text = "주차";
			this.button_parking.UseVisualStyleBackColor = false;
			this.button_parking.Click += new System.EventHandler(this.button_parking_Click);
			// 
			// textBox_phoneNumber
			// 
			this.textBox_phoneNumber.Location = new System.Drawing.Point(65, 99);
			this.textBox_phoneNumber.Name = "textBox_phoneNumber";
			this.textBox_phoneNumber.Size = new System.Drawing.Size(100, 21);
			this.textBox_phoneNumber.TabIndex = 7;
			// 
			// textBox_driverName
			// 
			this.textBox_driverName.Location = new System.Drawing.Point(65, 72);
			this.textBox_driverName.Name = "textBox_driverName";
			this.textBox_driverName.Size = new System.Drawing.Size(100, 21);
			this.textBox_driverName.TabIndex = 6;
			// 
			// textBox_carNumber
			// 
			this.textBox_carNumber.Location = new System.Drawing.Point(65, 45);
			this.textBox_carNumber.Name = "textBox_carNumber";
			this.textBox_carNumber.Size = new System.Drawing.Size(100, 21);
			this.textBox_carNumber.TabIndex = 5;
			this.textBox_carNumber.TextChanged += new System.EventHandler(this.textBox_carNumber_TextChanged);
			// 
			// textBox_parkingSpot
			// 
			this.textBox_parkingSpot.Location = new System.Drawing.Point(65, 17);
			this.textBox_parkingSpot.Name = "textBox_parkingSpot";
			this.textBox_parkingSpot.Size = new System.Drawing.Size(100, 21);
			this.textBox_parkingSpot.TabIndex = 4;
			// 
			// label5
			// 
			this.label5.AutoSize = true;
			this.label5.Location = new System.Drawing.Point(6, 102);
			this.label5.Name = "label5";
			this.label5.Size = new System.Drawing.Size(53, 12);
			this.label5.TabIndex = 3;
			this.label5.Text = "전화번호";
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.Location = new System.Drawing.Point(6, 75);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(53, 12);
			this.label4.TabIndex = 2;
			this.label4.Text = "등록세대";
			this.label4.Click += new System.EventHandler(this.label4_Click);
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Location = new System.Drawing.Point(6, 48);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(53, 12);
			this.label3.TabIndex = 1;
			this.label3.Text = "차량번호";
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(6, 22);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(53, 12);
			this.label2.TabIndex = 0;
			this.label2.Text = "구역번호";
			// 
			// groupBox2
			// 
			this.groupBox2.BackColor = System.Drawing.Color.Lavender;
			this.groupBox2.Controls.Add(this.button_refresh);
			this.groupBox2.Controls.Add(this.button_delete);
			this.groupBox2.Controls.Add(this.button_add);
			this.groupBox2.Controls.Add(this.button_find);
			this.groupBox2.Controls.Add(this.textBox_findNum);
			this.groupBox2.Controls.Add(this.label6);
			this.groupBox2.Location = new System.Drawing.Point(452, 14);
			this.groupBox2.Name = "groupBox2";
			this.groupBox2.Size = new System.Drawing.Size(272, 148);
			this.groupBox2.TabIndex = 1;
			this.groupBox2.TabStop = false;
			this.groupBox2.Text = "주차 공간 현황 관리";
			// 
			// button_refresh
			// 
			this.button_refresh.BackColor = System.Drawing.Color.Silver;
			this.button_refresh.Location = new System.Drawing.Point(181, 106);
			this.button_refresh.Name = "button_refresh";
			this.button_refresh.Size = new System.Drawing.Size(75, 23);
			this.button_refresh.TabIndex = 13;
			this.button_refresh.Text = "전체 갱신";
			this.button_refresh.UseVisualStyleBackColor = false;
			this.button_refresh.Click += new System.EventHandler(this.button_refresh_Click);
			// 
			// button_delete
			// 
			this.button_delete.BackColor = System.Drawing.Color.Red;
			this.button_delete.Location = new System.Drawing.Point(181, 77);
			this.button_delete.Name = "button_delete";
			this.button_delete.Size = new System.Drawing.Size(75, 23);
			this.button_delete.TabIndex = 12;
			this.button_delete.Text = "위치 삭제";
			this.button_delete.UseVisualStyleBackColor = false;
			this.button_delete.Click += new System.EventHandler(this.button_delete_Click);
			// 
			// button_add
			// 
			this.button_add.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
			this.button_add.Location = new System.Drawing.Point(181, 48);
			this.button_add.Name = "button_add";
			this.button_add.Size = new System.Drawing.Size(75, 23);
			this.button_add.TabIndex = 11;
			this.button_add.Text = "위치 추가";
			this.button_add.UseVisualStyleBackColor = false;
			this.button_add.Click += new System.EventHandler(this.button_add_Click);
			// 
			// button_find
			// 
			this.button_find.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(255)))));
			this.button_find.Location = new System.Drawing.Point(181, 19);
			this.button_find.Name = "button_find";
			this.button_find.Size = new System.Drawing.Size(75, 23);
			this.button_find.TabIndex = 10;
			this.button_find.Text = "위치 조회";
			this.button_find.UseVisualStyleBackColor = false;
			this.button_find.Click += new System.EventHandler(this.button_find_Click);
			// 
			// textBox_findNum
			// 
			this.textBox_findNum.Location = new System.Drawing.Point(67, 19);
			this.textBox_findNum.Name = "textBox_findNum";
			this.textBox_findNum.Size = new System.Drawing.Size(100, 21);
			this.textBox_findNum.TabIndex = 10;
			// 
			// label6
			// 
			this.label6.AutoSize = true;
			this.label6.Location = new System.Drawing.Point(6, 23);
			this.label6.Name = "label6";
			this.label6.Size = new System.Drawing.Size(57, 12);
			this.label6.TabIndex = 10;
			this.label6.Text = "지정 위치";
			// 
			// groupBox3
			// 
			this.groupBox3.BackColor = System.Drawing.Color.Lavender;
			this.groupBox3.Controls.Add(this.dataGridView_parkingManager);
			this.groupBox3.Location = new System.Drawing.Point(164, 169);
			this.groupBox3.Name = "groupBox3";
			this.groupBox3.Size = new System.Drawing.Size(560, 179);
			this.groupBox3.TabIndex = 2;
			this.groupBox3.TabStop = false;
			this.groupBox3.Text = "주차 현황";
			// 
			// dataGridView_parkingManager
			// 
			this.dataGridView_parkingManager.BackgroundColor = System.Drawing.Color.WhiteSmoke;
			this.dataGridView_parkingManager.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.dataGridView_parkingManager.Location = new System.Drawing.Point(7, 20);
			this.dataGridView_parkingManager.Name = "dataGridView_parkingManager";
			this.dataGridView_parkingManager.RowTemplate.Height = 23;
			this.dataGridView_parkingManager.Size = new System.Drawing.Size(547, 153);
			this.dataGridView_parkingManager.TabIndex = 0;
			this.dataGridView_parkingManager.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView_parkingManager_CellClick);
			// 
			// 관리내역
			// 
			this.관리내역.BackColor = System.Drawing.Color.Cornsilk;
			this.관리내역.FormattingEnabled = true;
			this.관리내역.ItemHeight = 12;
			this.관리내역.Location = new System.Drawing.Point(164, 354);
			this.관리내역.Name = "관리내역";
			this.관리내역.Size = new System.Drawing.Size(560, 112);
			this.관리내역.TabIndex = 3;
			this.관리내역.SelectedIndexChanged += new System.EventHandler(this.listBox_log_SelectedIndexChanged);
			// 
			// label_now
			// 
			this.label_now.AutoSize = true;
			this.label_now.Location = new System.Drawing.Point(170, 488);
			this.label_now.Name = "label_now";
			this.label_now.Size = new System.Drawing.Size(38, 12);
			this.label_now.TabIndex = 4;
			this.label_now.Text = "label1";
			// 
			// timer_now
			// 
			this.timer_now.Enabled = true;
			this.timer_now.Interval = 1000;
			this.timer_now.Tick += new System.EventHandler(this.timer_now_Tick);
			// 
			// groupBox4
			// 
			this.groupBox4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
			this.groupBox4.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("groupBox4.BackgroundImage")));
			this.groupBox4.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
			this.groupBox4.Controls.Add(this.label9);
			this.groupBox4.Controls.Add(this.label8);
			this.groupBox4.Controls.Add(this.label7);
			this.groupBox4.Controls.Add(this.label1);
			this.groupBox4.Location = new System.Drawing.Point(12, 12);
			this.groupBox4.Name = "groupBox4";
			this.groupBox4.Size = new System.Drawing.Size(146, 488);
			this.groupBox4.TabIndex = 5;
			this.groupBox4.TabStop = false;
			this.groupBox4.Text = "Xii";
			this.groupBox4.Enter += new System.EventHandler(this.groupBox4_Enter);
			// 
			// label9
			// 
			this.label9.AutoSize = true;
			this.label9.Location = new System.Drawing.Point(7, 342);
			this.label9.Name = "label9";
			this.label9.Size = new System.Drawing.Size(91, 12);
			this.label9.TabIndex = 3;
			this.label9.Text = "지하 제1 주차장";
			// 
			// label8
			// 
			this.label8.AutoSize = true;
			this.label8.Location = new System.Drawing.Point(7, 363);
			this.label8.Name = "label8";
			this.label8.Size = new System.Drawing.Size(91, 12);
			this.label8.TabIndex = 2;
			this.label8.Text = "지하 제2 주차장";
			// 
			// label7
			// 
			this.label7.AutoSize = true;
			this.label7.Location = new System.Drawing.Point(7, 50);
			this.label7.Name = "label7";
			this.label7.Size = new System.Drawing.Size(91, 12);
			this.label7.TabIndex = 1;
			this.label7.Text = "지상 제2 주차장";
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(7, 29);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(91, 12);
			this.label1.TabIndex = 0;
			this.label1.Text = "지상 제1 주차장";
			// 
			// MainForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 12F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(741, 514);
			this.Controls.Add(this.groupBox4);
			this.Controls.Add(this.label_now);
			this.Controls.Add(this.관리내역);
			this.Controls.Add(this.groupBox3);
			this.Controls.Add(this.groupBox2);
			this.Controls.Add(this.groupBox1);
			this.Name = "MainForm";
			this.Text = "주차 관리 프로그램";
			this.groupBox1.ResumeLayout(false);
			this.groupBox1.PerformLayout();
			this.groupBox2.ResumeLayout(false);
			this.groupBox2.PerformLayout();
			this.groupBox3.ResumeLayout(false);
			((System.ComponentModel.ISupportInitialize)(this.dataGridView_parkingManager)).EndInit();
			this.groupBox4.ResumeLayout(false);
			this.groupBox4.PerformLayout();
			this.ResumeLayout(false);
			this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button button_remove;
        private System.Windows.Forms.Button button_parking;
        private System.Windows.Forms.TextBox textBox_phoneNumber;
        private System.Windows.Forms.TextBox textBox_driverName;
        private System.Windows.Forms.TextBox textBox_carNumber;
        private System.Windows.Forms.TextBox textBox_parkingSpot;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Button button_refresh;
        private System.Windows.Forms.Button button_delete;
        private System.Windows.Forms.Button button_add;
        private System.Windows.Forms.Button button_find;
        private System.Windows.Forms.TextBox textBox_findNum;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.DataGridView dataGridView_parkingManager;
        private System.Windows.Forms.ListBox 관리내역;
        private System.Windows.Forms.Label label_now;
        private System.Windows.Forms.Timer timer_now;
		private System.Windows.Forms.GroupBox groupBox4;
		private System.Windows.Forms.Label label9;
		private System.Windows.Forms.Label label8;
		private System.Windows.Forms.Label label7;
		private System.Windows.Forms.Label label1;
	}
}

