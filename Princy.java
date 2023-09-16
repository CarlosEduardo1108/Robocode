package princy;
import robocode.*;
import java.awt.Color;

 //Carlos - a class by (Carlos Eduardo Silva de França)
 //No início da partida, o robô deve se mover para frente em 100 pixels, voltar 40 e virar-se 30 graus para a esquerda.
public class Princy extends Robot {
    public void run () {
		setColors(Color.red,Color.black,Color.white,Color.white,Color.yellow);
	    while (true) {
			ahead(100);
		    back(40);
		    turnLeft(30);
		}
	}
	//Tanque inimigo foi detectado pelo scanner, após isso o robô atira de acordo com a distância entre eles.
	public void onScannedRobot (ScannedRobotEvent e) {
		String robo = e.getName();   //Obtem o nome do robô detectado pelo radar.
		double distancia = e.getDistance(); //Obtem a distância em pixels do robô inimigo.
		System.out.println(robo + " Distância " + distancia); //Vai mostrar no terminal, o nome do robô detectado e a distância que ele está do meu robô.
        if (distancia < 120) {        
			fire(3);
		} else {
			fire(1);
		}
	}
	 //Se a distância entre o meu robô e o robô inimigo for menor que 120 pixels, dispara com a carga máxima, caso contr[ario, atire com a menor carga.		
	//Se o robô colidir com a parede.
	public void onHitWall(HitWallEvent e) {
		back(30);
		turnLeft(40);
	}
}
//Se o robô bater na parede da arena, ele deve, voltar uma distância de 30 pixels e virar para a esquerda em 40 graus.
