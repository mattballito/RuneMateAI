package com.mattzabally.scripts.agility.gnome_village.leafs;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * 
 */
public class WalkAcrossLog extends LeafTask {

    @Override
    public void execute() {
        GameObject WalkableLog = GameObjects.newQuery().ids(23145).results().nearest();
        if (WalkableLog != null){
            int agilityXPbefore = Skill.AGILITY.getExperience();
            if (WalkableLog.isVisible()){
                if (WalkableLog.interact("Walk-across")){
                    Execution.delayUntil(()->!WalkableLog.isValid() || Skill.AGILITY.getExperience() > agilityXPbefore, 200, 15000);
                }
            }
            else{
                Camera.turnTo(WalkableLog);
            }
        }
        else{
            Environment.getBot().getLogger().info("The Log we looked for in WalkAcrossLog was null");
        }
    }
}
