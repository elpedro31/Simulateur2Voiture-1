package AppliSimu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import DomaineRoute.Route;
import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

    private double parametreConversionMetresPixels = 0.5;
    private Voiture maVoiture;
    private Route maRoute;
    private CommandeVoiture maCommandeVoiture;
    
    private void initGraphique() {
        this.setTitle("Simulateur de Voiture");
        this.setSize(505, 505);

        this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

        this.setVisible(true);
    }
    
    public IHMVoiture(Voiture maVoiture,Route maRoute) {
        super();
        this.maVoiture = maVoiture;
        this.maRoute = maRoute;
        maVoiture.addObserver(this);
        initGraphique();
    }

    public IHMVoiture() {
        super();
        initGraphique();
        this.maVoiture = null;
        this.maRoute=null;
    }
    
    public int calculerPositionPixels(int xMetres) {
        return (int) (parametreConversionMetresPixels * xMetres);    
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }

    @Override
    public void paint(Graphics contexteGraphique) {
        super.paint(contexteGraphique);
        dessinerRoute(contexteGraphique);
        dessinerVoiture(contexteGraphique);
    }


    private void dessinerVoiture(Graphics contexteGraphique) {
        int xMetres = maVoiture.getX();
        int xPixel = calculerPositionPixels(xMetres);
        int yMetres = maVoiture.getY();
        int yPixel = calculerPositionPixels(yMetres);
        contexteGraphique.setColor(Color.RED);
        contexteGraphique.fillRect(xPixel, yPixel, 30, 20);
    }

    private void dessinerRoute(Graphics contexteGraphique) {
        int xMetres = maRoute.getX();
        int yMetres = maRoute.getY();
        int xPixel = calculerPositionPixels(xMetres);
        int yPixel = calculerPositionPixels(yMetres);
        contexteGraphique.setColor(Color.DARK_GRAY);
        contexteGraphique.fillRect(xPixel, yPixel, 1000, 60);
    }
}