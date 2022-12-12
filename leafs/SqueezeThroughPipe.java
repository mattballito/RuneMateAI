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
public class SqueezeThroughPipe extends LeafTask {

    @Override
    public void execute() {
        GameObject SqueezablePipe = GameObjects.newQuery().ids(23138).results().nearest();
        if (SqueezablePipe != null){
            int agilityXPbefore = Skill.AGILITY.getExperience();
            if (SqueezablePipe.isVisible()){
                if (SqueezablePipe.interact("Squeeze-through")){
                    Execution.delayUntil(()->!SqueezablePipe.isValid() || Skill.AGILITY.getExperience() > agilityXPbefore, 200, 3000);
                }
            }
            else{
                Camera.turnTo(SqueezablePipe);
            }
        }
        else{
            Environment.getBot().getLogger().info("The Pipe we looked for in SqueezeThroughPipe was null");
        }
    }
}
