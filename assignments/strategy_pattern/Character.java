package assignments.strategy_pattern;

public class Character {
    private IWeapon characterWeapon;
    private String characterSpecies;

    // Character Constructor
    public Character(String characterSpecies, IWeapon characterWeapon) {
        this.characterSpecies = characterSpecies;
        this.characterWeapon = characterWeapon;
    }

    // Set character species
    public void setCharacterSpecies(String characterSpecies) {
        this.characterSpecies = characterSpecies;
    }

    // Set character weapon
    public void setCharacterWeapon(IWeapon characterWeapon) {
        this.characterWeapon = characterWeapon;
    }

    // get character species
    public String getSpecies() {
        return characterSpecies;
    }

    // get character weapon
    public String fireWeapon() {
        return characterWeapon.getWeapon();
    }
}
