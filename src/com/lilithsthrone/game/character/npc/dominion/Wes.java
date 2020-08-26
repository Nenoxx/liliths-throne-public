package com.lilithsthrone.game.character.npc.dominion;

import java.time.Month;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.lilithsthrone.game.PropertyValue;
import com.lilithsthrone.game.character.CharacterImportSetting;
import com.lilithsthrone.game.character.EquipClothingSetting;
import com.lilithsthrone.game.character.body.Covering;
import com.lilithsthrone.game.character.body.types.BodyCoveringType;
import com.lilithsthrone.game.character.body.valueEnums.AreolaeSize;
import com.lilithsthrone.game.character.body.valueEnums.AssSize;
import com.lilithsthrone.game.character.body.valueEnums.BodyHair;
import com.lilithsthrone.game.character.body.valueEnums.BreastShape;
import com.lilithsthrone.game.character.body.valueEnums.Capacity;
import com.lilithsthrone.game.character.body.valueEnums.CoveringModifier;
import com.lilithsthrone.game.character.body.valueEnums.CoveringPattern;
import com.lilithsthrone.game.character.body.valueEnums.CupSize;
import com.lilithsthrone.game.character.body.valueEnums.FootStructure;
import com.lilithsthrone.game.character.body.valueEnums.HairLength;
import com.lilithsthrone.game.character.body.valueEnums.HairStyle;
import com.lilithsthrone.game.character.body.valueEnums.HipSize;
import com.lilithsthrone.game.character.body.valueEnums.LipSize;
import com.lilithsthrone.game.character.body.valueEnums.NippleSize;
import com.lilithsthrone.game.character.body.valueEnums.OrificeElasticity;
import com.lilithsthrone.game.character.body.valueEnums.OrificePlasticity;
import com.lilithsthrone.game.character.body.valueEnums.PenetrationGirth;
import com.lilithsthrone.game.character.body.valueEnums.TesticleSize;
import com.lilithsthrone.game.character.body.valueEnums.TongueLength;
import com.lilithsthrone.game.character.body.valueEnums.Wetness;
import com.lilithsthrone.game.character.effects.Perk;
import com.lilithsthrone.game.character.effects.PerkCategory;
import com.lilithsthrone.game.character.effects.PerkManager;
import com.lilithsthrone.game.character.fetishes.Fetish;
import com.lilithsthrone.game.character.fetishes.FetishDesire;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.persona.NameTriplet;
import com.lilithsthrone.game.character.persona.Occupation;
import com.lilithsthrone.game.character.persona.PersonalityTrait;
import com.lilithsthrone.game.character.persona.SexualOrientation;
import com.lilithsthrone.game.character.quests.QuestLine;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.Subspecies;
import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.inventory.CharacterInventory;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.Value;
import com.lilithsthrone.utils.colours.PresetColour;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

/**
 * @since 0.3.9.4
 * @version 0.3.9.4
 * @author DSG, Innoxia
 */
public class Wes extends NPC {
	
	public Wes() {
		this(false);
	}
	
	public Wes(boolean isImported) {
		super(isImported, new NameTriplet("Wesley"), "Wormwood",
				"",
				38, Month.MARCH, 28,
				20,
				Gender.M_P_MALE, Subspecies.FOX_MORPH, RaceStage.GREATER,
				new CharacterInventory(10),
				WorldType.ENFORCER_HQ, PlaceType.ENFORCER_HQ_REQUISITIONS,
				true);
		
		if(!isImported) {
			this.setPlayerKnowsName(false);
			this.setGenericName("mysterious Enforcer");
		}
	}
	
	@Override
	public void loadFromXML(Element parentElement, Document doc, CharacterImportSetting... settings) {
		loadNPCVariablesFromXML(this, null, parentElement, doc, settings);
	}

	@Override
	public void setupPerks(boolean autoSelectPerks) {
		this.addSpecialPerk(Perk.SPECIAL_MARTIAL_BACKGROUND);
		
		PerkManager.initialisePerks(this,
				Util.newArrayListOfValues(),
				Util.newHashMapOfValues(
						new Value<>(PerkCategory.PHYSICAL, 1),
						new Value<>(PerkCategory.LUST, 0),
						new Value<>(PerkCategory.ARCANE, 0)));
	}
	
	@Override
	public void setStartingBody(boolean setPersona) {
		
		// Persona:

		if(setPersona) {
			this.setPersonalityTraits(PersonalityTrait.CYNICAL);
			
			this.setSexualOrientation(SexualOrientation.GYNEPHILIC);
			
			this.setHistory(Occupation.NPC_ENFORCER_SWORD_INSPECTOR);
			
			this.setFetishDesire(Fetish.FETISH_SADIST, FetishDesire.ONE_DISLIKE);
		}
		
		// Body:
		this.setFootStructure(FootStructure.DIGITIGRADE);
		
		// Core:
		this.setHeight(173);
		this.setFemininity(20);
		this.setMuscle(70);
		this.setBodySize(30);
		
		// Coverings:
		this.setEyeCovering(new Covering(BodyCoveringType.EYE_FOX_MORPH, PresetColour.EYE_GREEN));
		this.setSkinCovering(new Covering(BodyCoveringType.FOX_FUR, CoveringPattern.MARKED, CoveringModifier.FLUFFY, PresetColour.COVERING_ORANGE, false, PresetColour.COVERING_WHITE, false), true);
		this.setSkinCovering(new Covering(BodyCoveringType.HUMAN, PresetColour.SKIN_LIGHT), true);
		this.setEyeCovering(new Covering(BodyCoveringType.PENIS, PresetColour.SKIN_RED));

		this.setHairCovering(new Covering(BodyCoveringType.HAIR_FOX_FUR, PresetColour.COVERING_BROWN), true);
		this.setHairLength(HairLength.ZERO_BALD);
		this.setHairStyle(HairStyle.SLICKED_BACK);
		
		this.setHairCovering(new Covering(BodyCoveringType.BODY_HAIR_FOX_FUR, PresetColour.COVERING_WHITE), false);
		this.setUnderarmHair(BodyHair.FOUR_NATURAL);
		this.setAssHair(BodyHair.TWO_MANICURED);
		this.setPubicHair(BodyHair.FOUR_NATURAL);
		this.setFacialHair(BodyHair.ZERO_NONE);
		
		// Face:
		this.setFaceVirgin(true);
		this.setLipSize(LipSize.ONE_AVERAGE);
		this.setFaceCapacity(Capacity.ZERO_IMPENETRABLE, true);
		this.setTongueLength(TongueLength.ZERO_NORMAL.getMedianValue());
		
		// Chest:
		this.setNippleVirgin(true);
		this.setBreastSize(CupSize.FLAT.getMeasurement());
		this.setBreastShape(BreastShape.POINTY);
		this.setNippleSize(NippleSize.ZERO_TINY);
		this.setAreolaeSize(AreolaeSize.ZERO_TINY);
		
		// Ass:
		this.setAssVirgin(true);
		this.setAssBleached(false);
		this.setAssSize(AssSize.TWO_SMALL);
		this.setHipSize(HipSize.TWO_NARROW);
		this.setAssCapacity(Capacity.ZERO_IMPENETRABLE, true);
		this.setAssWetness(Wetness.ZERO_DRY);
		this.setAssElasticity(OrificeElasticity.ONE_RIGID.getValue());
		this.setAssPlasticity(OrificePlasticity.THREE_RESILIENT.getValue());
		
		// Penis:
		this.setPenisVirgin(false);
		this.setPenisGirth(PenetrationGirth.THREE_AVERAGE);
		this.setPenisSize(17);
		this.setTesticleSize(TesticleSize.TWO_AVERAGE);
	}
	
	@Override
	public void equipClothing(List<EquipClothingSetting> settings) {
		this.unequipAllClothingIntoVoid(true, true);
		
		if(isSlave()) {
			this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_bdsm_metal_collar", PresetColour.CLOTHING_BRASS, false), true, this);

			this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.GROIN_BOXERS, PresetColour.CLOTHING_BLACK, false), true, this);
			
		} else {
			this.setEssenceCount(100);
			this.equipMainWeaponFromNowhere(Main.game.getItemGen().generateWeapon("dsg_eep_pbweap_pbpistol"));
			
			if(this.getWorldLocation()!=WorldType.ENFORCER_HQ) {
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.GROIN_BOXERS, PresetColour.CLOTHING_BLACK, false), true, this);
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_sock_socks", PresetColour.CLOTHING_GREY_LIGHT, false), true, this);

				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.TORSO_OVER_HOODIE, PresetColour.CLOTHING_GREY, false), true, this);
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_torso_tshirt", PresetColour.CLOTHING_GREEN_DARK, false), true, this);
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_leg_jeans", PresetColour.CLOTHING_BLUE_GREY, PresetColour.CLOTHING_BRASS, null, false), true, this);
				
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_foot_trainers", PresetColour.CLOTHING_DESATURATED_BROWN, PresetColour.CLOTHING_GREY, PresetColour.CLOTHING_GREY_DARK, false), true, this);
				
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_eye_glasses", PresetColour.CLOTHING_BLACK_STEEL, PresetColour.CLOTHING_BLACK_STEEL, PresetColour.CLOTHING_BLACK_JET, false), true, this);
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_sock_socks", PresetColour.CLOTHING_GREY_LIGHT, false), true, this);
				
			} else {
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.GROIN_BOXERS, PresetColour.CLOTHING_BLACK, false), true, this);
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_sock_socks", PresetColour.CLOTHING_BLACK, false), true, this);
				
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("dsg_eep_ptrlequipset_lsldshirt", PresetColour.CLOTHING_GREY, PresetColour.CLOTHING_BLACK, PresetColour.CLOTHING_GOLD, false), true, this);
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("dsg_eep_servequipset_enfdslacks", PresetColour.CLOTHING_BLACK, PresetColour.CLOTHING_GOLD, PresetColour.CLOTHING_GREY, false), true, this);
				
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_neck_tie", PresetColour.CLOTHING_BLACK, false), true, this);
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("dsg_eep_uniques_enfdjacket_wesley", PresetColour.CLOTHING_BLACK, PresetColour.CLOTHING_GREY, PresetColour.CLOTHING_GOLD, false), true, this);
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("dsg_eep_servequipset_enfdbelt", PresetColour.CLOTHING_DESATURATED_BROWN, PresetColour.CLOTHING_DESATURATED_BROWN, PresetColour.CLOTHING_GOLD, false), true, this);
				
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("innoxia_foot_mens_smart_shoes", PresetColour.CLOTHING_BLACK, PresetColour.CLOTHING_BLACK, PresetColour.CLOTHING_BLACK, false), true, this);
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing("dsg_eep_servequipset_enfberet_sword", PresetColour.CLOTHING_GREY, PresetColour.CLOTHING_BLACK, null, false), true, this);
				
				this.equipClothingFromNowhere(Main.game.getItemGen().generateClothing(ClothingType.WRIST_MENS_WATCH, PresetColour.CLOTHING_SILVER, false), true, this);
			}
		}
	}

	@Override
	public String getArtworkFolderName() {
		return this.getNameIgnoresPlayerKnowledge();
	}
	
	@Override
	public boolean isUnique() {
		return true;
	}
	
	@Override
	public String getDescription() {
		if(this.isSlave()) {
			return "Wes was once the Junior Quartermaster for all of the Enforcers in Central Dominion. Thanks to you, he is now a plaything of his former commanding officer, Elle.";
			
		} else if(Main.game.getPlayer().isQuestCompleted(QuestLine.SIDE_WES)) {
			return "With your help, Wes is now the Senior Quartermaster for all of the Enforcers in Central Dominion. Although he seems to enjoy his promotion, owning Elle has nonetheless left him a bit frazzled.";
			
		} else {
			return "Wes is the Junior Quartermaster for all of the Enforcers in Central Dominion. He lacks the usual shiftiness foxes are stereotyped for and instead projects a sort of folksy naiveté.";
		}
	}
	
	@Override
	public void turnUpdate() {
		if(!Main.game.getCharactersPresent().contains(this)) {
			if(Main.game.isWorkTime()) {
				if(!this.isSlave()) {
					this.setLocation(WorldType.ENFORCER_HQ, PlaceType.ENFORCER_HQ_REQUISITIONS, true);
				} else {
					this.setLocation(WorldType.ENFORCER_HQ, PlaceType.ENFORCER_HQ_OFFICE_QUARTERMASTER, true);
				}
				
			} else {
				this.setLocation(WorldType.EMPTY, PlaceType.GENERIC_HOLDING_CELL, false);
			}
		}
	}
	
	@Override
	public boolean isAbleToBeImpregnated() {
		return true;
	}

	@Override
	public String getSpeechColour() {//TODO
		if(Main.getProperties().hasValue(PropertyValue.lightTheme)) {
			return "#d69423";
		}
		return "#d6c19c";
	}

	@Override
	public void changeFurryLevel() {
	}
	
	@Override
	public DialogueNode getEncounterDialogue() {
		return null;
	}

	
}
