package jp.co.bananadream.game;

/**
 * 赤モンスタークラス
 */
public class RedMonster extends Monster {

    /**
     * コンストラクタ
     */
    /**
     * @param name 名前の文字列
     * @param hp 体力の数値
     * @param offense 攻撃力の数値
     * @param defense 守備力の数値
     * @param quickly 素早さの数値
     */
    public RedMonster(String name, int hp, int offense, int defense, int quickly) {
        super(name, TYPE_RED, hp, offense, defense, quickly);
    }

    /*
     * @see Monster#Attack(int)
     */
    @Override
    public int Attack(int type) {
        int offensivePower = getOffense();
        if (type == TYPE_BLUE) {
            offensivePower = (int)(offensivePower * 0.75);
        }
        else if (type == TYPE_GREEN) {
            offensivePower = (int)(offensivePower * 1.25);
        }
        return offensivePower;
    }
}
