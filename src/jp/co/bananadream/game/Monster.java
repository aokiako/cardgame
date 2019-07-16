package jp.co.bananadream.game;

import java.util.Random;

/**
 * モンスター抽象クラス
 */
public abstract class Monster implements CardGame{

    /** モンスター名
     */
    private String name;

    /** モンスター属性
    */
    private int type;

    /** 体力
    */
    private int hp;

    /** 攻撃力
    */
    private int offense;

    /** 守備力
    */
    private int defense;

    /** 素早さ
     */
    private int quickly;

    /**
     * コンストラクタ
     * @param name 名前の文字列
     * @param type 属性の文字列
     * @param hp 体力の数値
     * @param offense 攻撃力の数値
     * @param defense 守備力の数値
     *  @param quickly 素早さの数値
     */
    public Monster(String name, int type, int hp, int offense, int defense, int quickly) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.offense = offense;
        this.defense = defense;
        this.quickly = quickly;
    }

    /**
     * カードの正当性チェック
     * @return falseなら不正数値
     */
    public boolean isCheck() {
    	return hp + offense + defense + quickly <= 100;
//    if(hp + offense + defense + quickly <= 100) {
//    	return true;
//    }else {
//    	return false;
//
//    }
    }
    /**
     * 攻撃数値を求める（３すくみ計算）
     * @return 攻撃数値
     */
    public abstract int Attack(int type);

    /**
     * 攻撃を受け止める
     * @return ダメージ
     */
    public int Defense(int offensivePower) {
		int damage = offensivePower - getDefense();
		if(damage < 0) {
			damage = 0;
		}
		hp = getHp() - damage;

    	return damage;

    }

    /**
     * 攻撃回避判定
     * @return falseなら回避
     */
    public boolean isHit() {
    	Random rand = new Random();
    	int rnd =0;
    		if (quickly > 5) {
    	    	rnd =rand.nextInt(4);
    		}else {
    	    	rnd =rand.nextInt(5);
    		}
    		if(rnd ==0) {
    			return false;
    		}else {
    			return true;
    		}

        }


    /**
     * 生存判定
     * @return trueなら生存
     */
    public boolean isSurvive() {
        if (hp <= 0) {
            return false;
        }else {
        return true;
    }
    }
    /**
     * nameを取得する
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * typeを取得する
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * hpを取得する
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * offenseを取得する
     * @return offense
     */
    public int getOffense() {
        return offense;
    }

    /**
     * defenseを取得する
     * @return defense
     */
    public int getDefense() {
        return defense;
    }

    /**
     * quicklyを取得する
     * @return quickly
     */
    public int getQuickly() {
        return quickly;
    }

    @Override
	public String toString() {
    	StringBuilder sb = new StringBuilder();

    	sb.append(name);
    	sb.append("が現れた。 [");
    	sb.append(type);
    	sb.append("タイプ ");
    	sb.append("体力:");
    	sb.append(hp);
    	sb.append("攻撃力:");
    	sb.append(offense);
    	sb.append("守備力:");
    	sb.append(defense);
    	sb.append("素早さ:");
    	sb.append(quickly);
    	sb.append("]");

		return sb.toString();


	}


}
