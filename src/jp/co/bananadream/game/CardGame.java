package jp.co.bananadream.game;
/**
 * カードゲームインターフェース
 */
public interface CardGame {

    /** モンスタータイプ：赤 */
    public static int TYPE_RED = 1;

    /** モンスタータイプ：青 */
    public static int TYPE_BLUE = 2;

    /** モンスタータイプ：緑 */
    public static int TYPE_GREEN = 3;

    /**
     * 攻撃数値を求める（３すくみ計算）
     * @return 攻撃数値
     * @param type 攻撃数値
     */
    public int Attack(int type);

    /**
     * 攻撃を受け止める
     * @return ダメージ
     * @param offensivePower ダメージ
     */
    public int Defense(int offensivePower);


    /**
     * 攻撃回避判定
     * @return falseなら回避
     */
    public boolean isHit();

    /**
     * 生存判定
     * @return trueなら生存
     */
    public boolean isSurvive();

    /**
     * nameを取得する
     * @return name
     */
    public String getName();

    /**
     * typeを取得する
     * @return type
     */
    public int getType();

    /**
     * hpを取得する
     * @return hp
     */
    public int getHp();

    /**
     * offenseを取得する
     * @return offense
     */
    public int getOffense();

    /**
     * defenseを取得する
     * @return defense
     */
    public int getDefense();

    /**
     * quicklyを取得する
     * @return quickly
     */
    public int getQuickly();

}
