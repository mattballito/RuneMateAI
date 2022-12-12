package com.mattzabally.scripts.agility.gnome_village;

import com.mattzabally.scripts.agility.gnome_village.branches.inZone1;
import com.mattzabally.scripts.agility.gnome_village.leafs.WalkAcrossLog;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.WalkAcrossLog
//import path.to.your.inZone1

/**
 * NOTES:
 *
 */
public class inStartingZone extends BranchTask {

    private WalkAcrossLog walkacrosslog = new WalkAcrossLog();
    private inZone1 inzone1 = new inZone1();

    private Coordinate startingA = new Coordinate(2472, 3439, 0);
    private Coordinate startingB = new Coordinate(2489, 3436, 0);

    Area.Rectangular startingRectangle = new Area.Rectangular(startingA,startingB);

    private Player player;

    @Override
    public boolean validate() {
        return (player = Players.getLocal()) != null && startingRectangle.contains(player);
    }

    @Override
    public TreeTask failureTask() {
        return inzone1;
    }

    @Override
    public TreeTask successTask() {
        return walkacrosslog;
    }
}
