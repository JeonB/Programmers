function solution(bandage, health, attacks) {
    let currentHealth = health;
    const lastAttackTime = attacks[attacks.length - 1][0];
    let continuousSuccessToHeal = 0;
    const [healTime, heal, additionalHeal] = bandage;

    let attackIndex = 0;
    for (let i = 1; i <= lastAttackTime; i++) {
        if (attackIndex < attacks.length && attacks[attackIndex][0] === i) {
            currentHealth -= attacks[attackIndex][1];
            if (currentHealth <= 0) return -1;
            continuousSuccessToHeal = 0;
            attackIndex++;
        } else {
            if (continuousSuccessToHeal < healTime) {
                currentHealth += heal;
                continuousSuccessToHeal++;
            }
            if (continuousSuccessToHeal === healTime) {
                currentHealth += additionalHeal;
                continuousSuccessToHeal = 0;
            }
            if (currentHealth > health) {
                currentHealth = health;
            }
        }
    }

    return currentHealth <= 0 ? -1 : currentHealth;
}
