package AppliSimu;

import DomaineRoute.Exceptions.PositionInvalideException;
import DomaineRoute.Route;
import DomaineVoiture.Voiture;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 21103619 on 09/04/2015.
 */
public class ProtoSimuRouteVerticale {

    public static final int dureeUneSecondeEnMilliSecondes = 1000;

    public static void main(String[] args) throws PositionInvalideException {

        final Voiture maVoiture = new Voiture (100, 0, 10);
        maVoiture.setDirection(90);
        final Route maRoute = new Route(0,600,90);
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
