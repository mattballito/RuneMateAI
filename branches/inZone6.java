package com.mattzabally.scripts.agility.gnome_village.branches;

import com.mattzabally.scripts.agility.gnome_village.leafs.SqueezeThroughPipe;
import com.mattzabally.scripts.agility.gnome_village.leafs.Stop;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.SqueezeThroughPipe
//import path.to.your.Stop

/**
 * NOTES:
 * 
 */
public class inZone6 extends BranchTask {
    private Coordinate startingA = new Coordinate(2482,3427,0);
    private Coordinate startingB = new Coordinate(2489,3431,0);

    Area.Rectangular zone6Rectangle = new Area.Rectangular(startingA,startingB);


    private Player player;
    private SqueezeThroughPipe squeezethroughpipe = new SqueezeThroughPipe();
    private Stop stop = new Stop();

    @Override
    public boolean validate() {
        return (player = Players.getLocal()) != null && zone6Rectangle.contains(player);
    }

    @Override
    public TreeTask failureTask() {
        return stop;
    }

    @Override
    public TreeTask successTask() {
        return squeezethroughpipe;
    }
}
