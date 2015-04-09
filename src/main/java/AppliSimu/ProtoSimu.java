package AppliSimu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import DomaineRoute.Exceptions.PositionInvalideException;
import DomaineRoute.Route;
import DomaineVoiture.Voiture;

public class ProtoSimu {

    public static final int dureeUneSecondeEnMilliSecondes = 1000;

    public static void main(String[] args) throws PositionInvalideException {

        final Voiture maVoiture = new Voiture (10, 600, 10);
        final Route maRoute = new Route(0,600,0);
        IHMVoiture maVoitureIHM = new IHMVoiture(maVoiture,maRoute);
        
        Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                maVoiture.miseAJourPosition();
            }
        });
        
        timerAvancer.start();
        
        while(true){
        }

    }

}
