package assignments.strategy_pattern;

public class Character {
    private ICharacterSpecies characterSpecies;
    private IWeapon characterWeapon;

    // Character Constructor
    public Character(ICharacterSpecies characterSpecies, IWeapon characterWeapon) {
        this.characterSpecies = characterSpecies;
        this.characterWeapon = characterWeapon;
    }

    // Set character species
    public void setCharacterSpecies(ICharacterSpecies characterSpecies) {
        this.characterSpecies = characterSpecies;
    }

    // Set character weapon
    public void setCharacterWeapon(IWeapon characterWeapon) {
        this.characterWeapon = characterWeapon;
    }

    // get character species
    public String turnSpecies() {
        return characterSpecies.getSpecies();
    }

    // get character weapon
    public String fireWeapon() {
        return characterWeapon.getWeapon();
    }
}
