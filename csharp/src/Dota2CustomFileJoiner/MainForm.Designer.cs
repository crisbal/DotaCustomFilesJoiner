namespace Dota2CustomFileJoiner
{
    partial class MainForm
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.abilitiesLabel = new System.Windows.Forms.Label();
            this.unitsLabel = new System.Windows.Forms.Label();
            this.heroesLabel = new System.Windows.Forms.Label();
            this.itemsLabel = new System.Windows.Forms.Label();
            this.checkIgnoreDisabled = new System.Windows.Forms.CheckBox();
            this.checkIgnoreSyntaxError = new System.Windows.Forms.CheckBox();
            this.checkShowErrorMsg = new System.Windows.Forms.CheckBox();
            this.joinAllBtn = new System.Windows.Forms.Button();
            this.joinAbilitiesBtn = new System.Windows.Forms.Button();
            this.joinUnitsBtn = new System.Windows.Forms.Button();
            this.joinHeroesBtn = new System.Windows.Forms.Button();
            this.joinItemsBtn = new System.Windows.Forms.Button();
            this.console = new System.Windows.Forms.RichTextBox();
            this.checkScrollConsole = new System.Windows.Forms.CheckBox();
            this.checkBackupOldFile = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // abilitiesLabel
            // 
            this.abilitiesLabel.AutoSize = true;
            this.abilitiesLabel.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.abilitiesLabel.Location = new System.Drawing.Point(10, 20);
            this.abilitiesLabel.Name = "abilitiesLabel";
            this.abilitiesLabel.Size = new System.Drawing.Size(66, 19);
            this.abilitiesLabel.TabIndex = 0;
            this.abilitiesLabel.Text = "Abilities";
            // 
            // unitsLabel
            // 
            this.unitsLabel.AutoSize = true;
            this.unitsLabel.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.unitsLabel.Location = new System.Drawing.Point(10, 46);
            this.unitsLabel.Name = "unitsLabel";
            this.unitsLabel.Size = new System.Drawing.Size(46, 19);
            this.unitsLabel.TabIndex = 1;
            this.unitsLabel.Text = "Units";
            // 
            // heroesLabel
            // 
            this.heroesLabel.AutoSize = true;
            this.heroesLabel.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.heroesLabel.Location = new System.Drawing.Point(10, 72);
            this.heroesLabel.Name = "heroesLabel";
            this.heroesLabel.Size = new System.Drawing.Size(59, 19);
            this.heroesLabel.TabIndex = 2;
            this.heroesLabel.Text = "Heroes";
            // 
            // itemsLabel
            // 
            this.itemsLabel.AutoSize = true;
            this.itemsLabel.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.itemsLabel.Location = new System.Drawing.Point(10, 98);
            this.itemsLabel.Name = "itemsLabel";
            this.itemsLabel.Size = new System.Drawing.Size(49, 19);
            this.itemsLabel.TabIndex = 3;
            this.itemsLabel.Text = "Items";
            // 
            // checkIgnoreDisabled
            // 
            this.checkIgnoreDisabled.AutoSize = true;
            this.checkIgnoreDisabled.Checked = true;
            this.checkIgnoreDisabled.CheckState = System.Windows.Forms.CheckState.Checked;
            this.checkIgnoreDisabled.Location = new System.Drawing.Point(14, 131);
            this.checkIgnoreDisabled.Name = "checkIgnoreDisabled";
            this.checkIgnoreDisabled.Size = new System.Drawing.Size(180, 16);
            this.checkIgnoreDisabled.TabIndex = 4;
            this.checkIgnoreDisabled.Text = "ignore file start with \"_\"";
            this.checkIgnoreDisabled.UseVisualStyleBackColor = true;
            this.checkIgnoreDisabled.CheckedChanged += new System.EventHandler(this.checkIgnoreDisabled_CheckedChanged);
            // 
            // checkIgnoreSyntaxError
            // 
            this.checkIgnoreSyntaxError.AutoSize = true;
            this.checkIgnoreSyntaxError.Checked = true;
            this.checkIgnoreSyntaxError.CheckState = System.Windows.Forms.CheckState.Checked;
            this.checkIgnoreSyntaxError.Location = new System.Drawing.Point(14, 153);
            this.checkIgnoreSyntaxError.Name = "checkIgnoreSyntaxError";
            this.checkIgnoreSyntaxError.Size = new System.Drawing.Size(198, 16);
            this.checkIgnoreSyntaxError.TabIndex = 5;
            this.checkIgnoreSyntaxError.Text = "ignore file with syntax error";
            this.checkIgnoreSyntaxError.UseVisualStyleBackColor = true;
            this.checkIgnoreSyntaxError.CheckedChanged += new System.EventHandler(this.checkIgnoreSyntaxError_CheckedChanged);
            // 
            // checkShowErrorMsg
            // 
            this.checkShowErrorMsg.AutoSize = true;
            this.checkShowErrorMsg.Checked = true;
            this.checkShowErrorMsg.CheckState = System.Windows.Forms.CheckState.Checked;
            this.checkShowErrorMsg.Location = new System.Drawing.Point(14, 175);
            this.checkShowErrorMsg.Name = "checkShowErrorMsg";
            this.checkShowErrorMsg.Size = new System.Drawing.Size(210, 16);
            this.checkShowErrorMsg.TabIndex = 6;
            this.checkShowErrorMsg.Text = "popup message when syntax error";
            this.checkShowErrorMsg.UseVisualStyleBackColor = true;
            this.checkShowErrorMsg.CheckedChanged += new System.EventHandler(this.checkShowErrorMsg_CheckedChanged);
            // 
            // joinAllBtn
            // 
            this.joinAllBtn.Location = new System.Drawing.Point(51, 220);
            this.joinAllBtn.Name = "joinAllBtn";
            this.joinAllBtn.Size = new System.Drawing.Size(143, 23);
            this.joinAllBtn.TabIndex = 7;
            this.joinAllBtn.Text = "Join All";
            this.joinAllBtn.UseVisualStyleBackColor = true;
            this.joinAllBtn.Click += new System.EventHandler(this.joinAllBtn_Click);
            // 
            // joinAbilitiesBtn
            // 
            this.joinAbilitiesBtn.Location = new System.Drawing.Point(82, 16);
            this.joinAbilitiesBtn.Name = "joinAbilitiesBtn";
            this.joinAbilitiesBtn.Size = new System.Drawing.Size(131, 23);
            this.joinAbilitiesBtn.TabIndex = 8;
            this.joinAbilitiesBtn.Text = "Join";
            this.joinAbilitiesBtn.UseVisualStyleBackColor = true;
            this.joinAbilitiesBtn.Click += new System.EventHandler(this.joinAbilitiesBtn_Click);
            // 
            // joinUnitsBtn
            // 
            this.joinUnitsBtn.Location = new System.Drawing.Point(81, 42);
            this.joinUnitsBtn.Name = "joinUnitsBtn";
            this.joinUnitsBtn.Size = new System.Drawing.Size(131, 23);
            this.joinUnitsBtn.TabIndex = 9;
            this.joinUnitsBtn.Text = "Join";
            this.joinUnitsBtn.UseVisualStyleBackColor = true;
            this.joinUnitsBtn.Click += new System.EventHandler(this.joinUnitsBtn_Click);
            // 
            // joinHeroesBtn
            // 
            this.joinHeroesBtn.Location = new System.Drawing.Point(81, 68);
            this.joinHeroesBtn.Name = "joinHeroesBtn";
            this.joinHeroesBtn.Size = new System.Drawing.Size(131, 23);
            this.joinHeroesBtn.TabIndex = 10;
            this.joinHeroesBtn.Text = "Join";
            this.joinHeroesBtn.UseVisualStyleBackColor = true;
            this.joinHeroesBtn.Click += new System.EventHandler(this.joinHeroesBtn_Click);
            // 
            // joinItemsBtn
            // 
            this.joinItemsBtn.Location = new System.Drawing.Point(82, 94);
            this.joinItemsBtn.Name = "joinItemsBtn";
            this.joinItemsBtn.Size = new System.Drawing.Size(131, 23);
            this.joinItemsBtn.TabIndex = 11;
            this.joinItemsBtn.Text = "Join";
            this.joinItemsBtn.UseVisualStyleBackColor = true;
            this.joinItemsBtn.Click += new System.EventHandler(this.joinItemsBtn_Click);
            // 
            // console
            // 
            this.console.Location = new System.Drawing.Point(238, 34);
            this.console.Name = "console";
            this.console.Size = new System.Drawing.Size(474, 219);
            this.console.TabIndex = 12;
            this.console.Text = "";
            // 
            // checkScrollConsole
            // 
            this.checkScrollConsole.AutoSize = true;
            this.checkScrollConsole.Location = new System.Drawing.Point(238, 12);
            this.checkScrollConsole.Name = "checkScrollConsole";
            this.checkScrollConsole.Size = new System.Drawing.Size(108, 16);
            this.checkScrollConsole.TabIndex = 13;
            this.checkScrollConsole.Text = "scroll console";
            this.checkScrollConsole.UseVisualStyleBackColor = true;
            this.checkScrollConsole.CheckedChanged += new System.EventHandler(this.checkScrollConsole_CheckedChanged);
            // 
            // checkBackupOldFile
            // 
            this.checkBackupOldFile.AutoSize = true;
            this.checkBackupOldFile.Location = new System.Drawing.Point(14, 198);
            this.checkBackupOldFile.Name = "checkBackupOldFile";
            this.checkBackupOldFile.Size = new System.Drawing.Size(114, 16);
            this.checkBackupOldFile.TabIndex = 14;
            this.checkBackupOldFile.Text = "backup old file";
            this.checkBackupOldFile.UseVisualStyleBackColor = true;
            this.checkBackupOldFile.CheckedChanged += new System.EventHandler(this.checkBackupOldFile_CheckedChanged);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(724, 255);
            this.Controls.Add(this.checkBackupOldFile);
            this.Controls.Add(this.checkScrollConsole);
            this.Controls.Add(this.console);
            this.Controls.Add(this.joinItemsBtn);
            this.Controls.Add(this.joinHeroesBtn);
            this.Controls.Add(this.joinUnitsBtn);
            this.Controls.Add(this.joinAbilitiesBtn);
            this.Controls.Add(this.joinAllBtn);
            this.Controls.Add(this.checkShowErrorMsg);
            this.Controls.Add(this.checkIgnoreSyntaxError);
            this.Controls.Add(this.checkIgnoreDisabled);
            this.Controls.Add(this.itemsLabel);
            this.Controls.Add(this.heroesLabel);
            this.Controls.Add(this.unitsLabel);
            this.Controls.Add(this.abilitiesLabel);
            this.Name = "MainForm";
            this.Text = "Dota 2 Custom File Joiner";
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label abilitiesLabel;
        private System.Windows.Forms.Label unitsLabel;
        private System.Windows.Forms.Label heroesLabel;
        private System.Windows.Forms.Label itemsLabel;
        private System.Windows.Forms.CheckBox checkIgnoreDisabled;
        private System.Windows.Forms.CheckBox checkIgnoreSyntaxError;
        private System.Windows.Forms.CheckBox checkShowErrorMsg;
        private System.Windows.Forms.Button joinAllBtn;
        private System.Windows.Forms.Button joinAbilitiesBtn;
        private System.Windows.Forms.Button joinUnitsBtn;
        private System.Windows.Forms.Button joinHeroesBtn;
        private System.Windows.Forms.Button joinItemsBtn;
        private System.Windows.Forms.RichTextBox console;
        private System.Windows.Forms.CheckBox checkScrollConsole;
        private System.Windows.Forms.CheckBox checkBackupOldFile;

    }
}

