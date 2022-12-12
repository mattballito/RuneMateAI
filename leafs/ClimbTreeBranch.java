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
public class ClimbTreeBranch extends LeafTask {

    @Override
    public void execute() {
        GameObject ClimbableTreeBranch = GameObjects.newQuery().ids(23559).results().nearest();
        if (ClimbableTreeBranch != null){
            int agilityXPbefore = Skill.AGILITY.getExperience();
            if (ClimbableTreeBranch.isVisible()){
                if (ClimbableTreeBranch.interact("Climb")){
                    Execution.delayUntil(()->!ClimbableTreeBranch.isValid() || Skill.AGILITY.getExperience() > agilityXPbefore, 200, 3000);
                }
            }
            else{
                Camera.turnTo(ClimbableTreeBranch);
            }
        }
        else{
            Environment.getBot().getLogger().info("The Tree Branch we looked for in Climb Tree Branch was null");
        }
    }
}
