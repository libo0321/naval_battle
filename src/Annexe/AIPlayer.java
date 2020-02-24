package Annexe;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

import Ship.*;

public class AIPlayer extends Player {
    /*
     * ** Attribut
     */
    private BattleShipsAI ai;

    /*
     * ** Constructeur
     */
    public AIPlayer(Board ownBoard, Board opponentBoard, List<AbstractShip> ships) {
        super(ownBoard, opponentBoard, ships);
        ai = new BattleShipsAI(ownBoard, opponentBoard);
    }

    // TODO AIPlayer must not inherit "keyboard behavior" from player. Call ai

    @Override
    public void putShips() {
        ai.putShips(ships);
    }

    @Override
    public Hit sendHit(int[] coords) {
        Hit hit = ai.sendHit(coords);
        return hit;
    }
}
