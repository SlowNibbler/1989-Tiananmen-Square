package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import insides.Tab;

public class GUIProjectPane extends JPanel
{
	private Tab theTab;
	
	private GridBagConstraints constraints;
	
	public GUIProjectPane(Tab currentTab)
	{
		theTab = currentTab;
		setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		
		JLabel title = new JLabel(theTab.getName());
		title.setFont(new Font("Tahoma", Font.BOLD, 36));
		setConstraints(0,0,1,1,0.8,0.1);
		add(title);
		
		JButton addProject = new JButton("Add Project");
		addProject.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Project added...");
			}
		});
		setConstraints(1,0,1,1,0.2,0.1);
		add(addProject);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(panel);
		
		JList projectList = loadProjects();
		scrollPane.setViewportView(projectList);
		setConstraints(0,1,2,1,1,0.9);
		add(scrollPane);
	}
	
	public JList loadProjects()
	{
		return new JList(theTab.getContents().toArray());
	}
	
	private void setConstraints(int x, int y, int w, int h, double wx, double wy)
	{
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		constraints.weightx = wx;
		constraints.weighty = wy;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.fill = GridBagConstraints.BOTH;
	}
}
