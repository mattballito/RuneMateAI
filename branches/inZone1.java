package com.mattzabally.scripts.agility.gnome_village.branches;

import com.mattzabally.scripts.agility.gnome_village.leafs.ClimbOverObstacleNetFirst;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.ClimbOverObstacleNetFirst
//import path.to.your.inZone2

/**
 * NOTES:
 * 
 */
public class inZone1 extends BranchTask {
    private Coordinate startingA = new Coordinate(2471, 3429, 0);
    private Coordinate startingB = new Coordinate(2480,3422,0);

    Area.Rectangular zone1Rectangle = new Area.Rectangular(startingA,startingB);


    private Player player;
    private ClimbOverObstacleNetFirst climboverobstaclenetfirst = new ClimbOverObstacleNetFirst();
    private inZone2 inzone2 = new inZone2();



    @Override
    public boolean validate() {
        return (player = Players.getLocal()) != null && zone1Rectangle.contains(player);
    }

    @Override
    public TreeTask failureTask() {
        return inzone2;
    }

    @Override
    public TreeTask successTask() {
        return climboverobstaclenetfirst;
    }
}
