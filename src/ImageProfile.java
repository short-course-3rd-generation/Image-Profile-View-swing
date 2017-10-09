import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ImageProfile extends JFrame{
	private JLabel imageView;
	private JPanel imagePanel;
	private JButton btnBrowse;
	private JPanel btnGroup;
	private static final String PROFILE_IMAGE="src/images/the-rock.jpg";
	
	public ImageProfile(){
		
		setSize(588,420);
		setTitle("Student Profile");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		imagePanel=new JPanel();
		imageView=new JLabel("The Rock");
		btnBrowse=new JButton("download ...");
		imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
		
		//align components to center
		imageView.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBrowse.setAlignmentX(Component.CENTER_ALIGNMENT);

		Border border= BorderFactory.createLineBorder(Color.RED);
		imagePanel.setBorder(new CompoundBorder(new EmptyBorder(5, 5, 5, 5), 
				border));
	
		imageView.setIcon(getImageIcon(PROFILE_IMAGE));
		
		//two lines below set text to below Image
		imageView.setHorizontalTextPosition(JLabel.CENTER);
		imageView.setVerticalTextPosition(JLabel.BOTTOM);
		
		imagePanel.add(imageView);
		imagePanel.add(btnBrowse);
		add(imagePanel);
		
	}
	
	protected ImageIcon getImageIcon(String imagePath){
		try {
			BufferedImage img=ImageIO.read(new File(PROFILE_IMAGE));
			ImageIcon icon=new ImageIcon(img);
			return icon;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String ...agrs){
		new ImageProfile().setVisible(true);
	}
}
