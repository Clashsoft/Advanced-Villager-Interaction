package clashsoft.mods.villagerquests;

import clashsoft.cslib.minecraft.entity.CSEntities;
import clashsoft.cslib.minecraft.init.ClashsoftMod;
import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.mods.villagerquests.common.AVIEventHandler;
import clashsoft.mods.villagerquests.common.AVIProxy;
import clashsoft.mods.villagerquests.entity.EntityVillager2;
import clashsoft.mods.villagerquests.entity.VQEntityProperties;
import clashsoft.mods.villagerquests.network.AVINetHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.entity.passive.EntityVillager;

@Mod(modid = VillagerQuestsMod.MODID, name = VillagerQuestsMod.NAME, version = VillagerQuestsMod.VERSION)
public class VillagerQuestsMod extends ClashsoftMod<AVINetHandler>
{
	public static final String		MODID	= "villagerquests";
	public static final String		NAME	= "Villager Quests Mod";
	public static final String		ACRONYM	= "vqm";
	public static final String		VERSION	= CSUpdate.CURRENT_VERSION + "-1.0.0";
	
	@Instance(MODID)
	public static VillagerQuestsMod	instance;
	
	public static AVIProxy			proxy	= createProxy("clashsoft.mods.villagerquests.client.AVIClientProxy", "clashsoft.mods.villagerquests.common.AVIProxy");
	
	public VillagerQuestsMod()
	{
		super(proxy, MODID, NAME, ACRONYM, VERSION);
		this.netHandlerClass = AVINetHandler.class;
		this.eventHandler = new AVIEventHandler();
		this.url = "https://github.com/Clashsoft/Villager-Quests-Mod/wiki/";
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		
		CSEntities.registerProperties("PlayerQuests", VQEntityProperties.class);
		CSEntities.replace(EntityVillager.class, EntityVillager2.class);
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
}
