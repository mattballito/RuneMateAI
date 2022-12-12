package com.mattzabally.scripts.agility.gnome_village.branches;

import com.mattzabally.scripts.agility.gnome_village.leafs.ClimbOverObstacleNetSecond;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.ClimbOverObstacleNetSecond
//import path.to.your.inZone6

/**
 * NOTES:
 * 
 */
public class inZone5 extends BranchTask {
    private Coordinate startingA = new Coordinate(2487,3420,0);
    private Coordinate startingB = new Coordinate(2482,3425,0);

    Area.Rectangular zone5Rectangle = new Area.Rectangular(startingA,startingB);


    private Player player;
    private ClimbOverObstacleNetSecond climboverobstaclenetsecond = new ClimbOverObstacleNetSecond();
    private inZone6 inzone6 = new inZone6();

    @Override
    public boolean validate() {
        return (player = Players.getLocal()) != null && zone5Rectangle.contains(player);
    }

    @Override
    public TreeTask failureTask() {
        return inzone6;
    }

    @Override
    public TreeTask successTask() {
        return climboverobstaclenetsecond;
    }
}
