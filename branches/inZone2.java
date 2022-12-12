package com.mattzabally.scripts.agility.gnome_village.branches;

import com.mattzabally.scripts.agility.gnome_village.leafs.ClimbTreeBranch;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.ClimbTreeBranch
//import path.to.your.inZone3

/**
 * NOTES:
 * 
 */
public class inZone2 extends BranchTask {
    private Coordinate startingA = new Coordinate(2471, 3424, 1);
    private Coordinate startingB = new Coordinate(2476,3422,1);

    Area.Rectangular zone2Rectangle = new Area.Rectangular(startingA,startingB);


    private Player player;
    private ClimbTreeBranch climbtreebranch = new ClimbTreeBranch();
    private inZone3 inzone3 = new inZone3();

    @Override
    public boolean validate() {
        return (player = Players.getLocal()) != null && zone2Rectangle.contains(player);
    }

    @Override
    public TreeTask failureTask() {
        return inzone3;
    }

    @Override
    public TreeTask successTask() {
        return climbtreebranch;
    }
}
