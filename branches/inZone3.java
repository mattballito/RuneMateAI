package com.mattzabally.scripts.agility.gnome_village.branches;

import com.mattzabally.scripts.agility.gnome_village.leafs.WalkOnRope;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.WalkOnRope
//import path.to.your.inZone4

/**
 * NOTES:
 * 
 */
public class inZone3 extends BranchTask {
    private Coordinate startingA = new Coordinate(2472,3420,2);
    private Coordinate startingB = new Coordinate(2477,3419,2);

    Area.Rectangular zone3Rectangle = new Area.Rectangular(startingA,startingB);


    private Player player;
    private WalkOnRope walkonrope = new WalkOnRope();
    private inZone4 inzone4 = new inZone4();

    @Override
    public boolean validate() {
        return (player = Players.getLocal()) != null && zone3Rectangle.contains(player);
    }

    @Override
    public TreeTask failureTask() {
        return inzone4;
    }

    @Override
    public TreeTask successTask() {
        return walkonrope;
    }
}
