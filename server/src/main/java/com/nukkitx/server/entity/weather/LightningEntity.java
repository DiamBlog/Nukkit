package com.nukkitx.server.entity.weather;

import com.flowpowered.math.vector.Vector3f;
import com.nukkitx.api.entity.weather.Lightning;
import com.nukkitx.server.NukkitServer;
import com.nukkitx.server.entity.BaseEntity;
import com.nukkitx.server.entity.EntityType;
import com.nukkitx.server.level.NukkitLevel;

public class LightningEntity extends BaseEntity implements Lightning {

    public LightningEntity(Vector3f position, NukkitServer server, NukkitLevel level) {
        super(EntityType.LIGHTNING_BOLT, position, level, server);
    }

    /* TODO: Update this code.
    protected boolean isEffect = true;

    public int state;
    public int liveTime;


    @Override
    protected void initEntity() {
        super.initEntity();

        this.setHealth(4);
        this.setMaxHealth(4);

        this.state = 2;
        this.liveTime = this.level.rand.nextInt(3) + 1;

        if (isEffect && this.level.gameRules.getBoolean("doFireTick") && (this.server.getDifficulty() >= 2)) {
            Block block = this.getLevelBlock();
            if (block.getId() == 0 || block.getId() == Block.TALL_GRASS) {
                BlockFire fire = new BlockFire();
                fire.x = block.x;
                fire.y = block.y;
                fire.z = block.z;
                fire.level = level;
                this.getLevel().setBlock(fire, fire, true);
                if (fire.isBlockTopFacingSurfaceSolid(fire.down()) || fire.canNeighborBurn()) {

                    BlockIgniteEvent e = new BlockIgniteEvent(block, null, this, BlockIgniteEvent.BlockIgniteCause.LIGHTNING);
                    getServer().getPluginManager().callEvent(e);

                    if (!e.isCancelled()) {
                        level.setBlock(fire, fire, true);
                        level.scheduleUpdate(fire, fire.tickRate() + level.rand.nextInt(10));
                    }
                }
            }
        }
    }

    public boolean isEffect() {
        return this.isEffect;
    }

    public void setEffect(boolean e) {
        this.isEffect = e;
    }

    @Override
    public boolean attack(EntityDamageEvent source) {
        //false?
        source.setDamage(0);
        return super.attack(source);
    }

    @Override
    public boolean onUpdate(int currentTick) {
        if (this.closed) {
            return false;
        }

        int tickDiff = currentTick - this.lastUpdate;

        if (tickDiff <= 0 && !this.justCreated) {
            return true;
        }

        this.lastUpdate = currentTick;

        this.entityBaseTick(tickDiff);

        if (this.state == 2) {
            this.level.addLevelSoundEvent(LevelSoundEventPacket.SOUND_THUNDER, 93, -1, this);
            this.level.addLevelSoundEvent(LevelSoundEventPacket.SOUND_EXPLODE, 93, -1, this);
        }

        this.state--;

        if (this.state < 0) {
            if (this.liveTime == 0) {
                this.close();
                return false;
            } else if (this.state < -this.level.rand.nextInt(10)) {
                this.liveTime--;
                this.state = 1;

                if (this.isEffect && this.level.gameRules.getBoolean("doFireTick")) {
                    Block block = this.getLevelBlock();

                    if (block.getId() == Block.AIR || block.getId() == Block.TALL_GRASS) {
                        BlockIgniteEvent e = new BlockIgniteEvent(block, null, this, BlockIgniteEvent.BlockIgniteCause.LIGHTNING);
                        getServer().getPluginManager().callEvent(e);

                        if (!e.isCancelled()) {
                            Block fire = new BlockFire();
                            this.level.setBlock(block, fire);
                            this.getLevel().scheduleUpdate(fire, fire.tickRate());
                        }
                    }
                }
            }
        }

        if (this.state >= 0) {
            if (this.isEffect) {
                AxisAlignedBB bb = getBoundingBox().grow(3, 3, 3);
                bb.maxX += 6;

                for (Entity entity : this.level.getCollidingEntities(bb, this)) {
                    entity.onStruckByLightning(this);
                }
            }
        }

        return true;
    }*/

}