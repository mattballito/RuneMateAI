package com.mattzabally.scripts.agility.gnome_village.branches;

import com.mattzabally.scripts.agility.gnome_village.leafs.ClimbDownTreeBranch;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.ClimbDownTreeBranch
//import path.to.your.inZone5

/**
 * NOTES:
 * 
 */
public class inZone4 extends BranchTask {
    private Coordinate startingA = new Coordinate(2483,3420,2);
    private Coordinate startingB = new Coordinate(2485,3419,2);

    Area.Rectangular zone4Rectangle = new Area.Rectangular(startingA,startingB);


    private Player player;
    private ClimbDownTreeBranch climbdowntreebranch = new ClimbDownTreeBranch();
    private inZone5 inzone5 = new inZone5();

    @Override
    public boolean validate() {
        return (player = Players.getLocal()) != null && zone4Rectangle.contains(player);
    }

    @Override
    public TreeTask failureTask() {
        return inzone5;
    }

    @Override
    public TreeTask successTask() {
        return climbdowntreebranch;
    }
}
