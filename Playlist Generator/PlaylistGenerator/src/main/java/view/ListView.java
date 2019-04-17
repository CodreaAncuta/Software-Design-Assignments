package view;

import java.util.List;

import javax.swing.JList;
import controller.ListViewController;
import model.Song;
import model.User;

/**
 *
 * @author Ancuta
 */
public class ListView extends javax.swing.JFrame implements IListView {

	private List<Song> listOfSongs;
	private User user;
	private String searchedPlaylist;
	
    /**
     * Creates new form ListView
     */
    public ListView(List<Song> listOfSongs, User u, String searchedPlaylist) {
    	setNimbus();
        initComponents();
        this.listOfSongs = listOfSongs;
        this.user = u;
        this.searchedPlaylist = searchedPlaylist;
        
        ListViewController listViewController = new ListViewController(this);
		removeSongButton.addActionListener(e -> listViewController.removeSong());
		songList.getSelectionModel().addListSelectionListener(e -> listViewController.songListSelectionListener());
    }

    private void setNimbus() {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
	}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        songList = new javax.swing.JList<>();
        removeSongButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PLAYLIST SONGS");

        jScrollPane1.setViewportView(songList);

        removeSongButton.setText("REMOVE SONG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(removeSongButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeSongButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeSongButton;
    private javax.swing.JList<String> songList;
    // End of variables declaration           
    
	@Override
	public JList getList() {
		return songList;
	}

	@Override
	public List<Song> getListOfSongs() {
		return listOfSongs;
	}

	@Override
	public void setJListSongs(String[] elements) {
		  songList.setModel(new javax.swing.AbstractListModel<String>() {
	            public int getSize() { return elements.length; }
	            public String getElementAt(int i) { return elements[i]; }
	        });
	}

	@Override
	public User getPlaylistOwner() {
		return user;
		
	}

	@Override
	public String getSearchedPlaylist() {
		return searchedPlaylist;
	}
}