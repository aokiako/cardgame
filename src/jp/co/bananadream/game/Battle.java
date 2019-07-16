package jp.co.bananadream.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * OfficeDrive
 * カードゲーム実行クラス
 * @version 1.0
 * @author a_aoki
 */
public class Battle {

	/**
	 *@param args 使用しない
	 */
	public static void main(String[] args) {
		System.out.println("＊＊＊ モンスターバトル in Bananaコロシアム ＊＊＊");
		//モンスター登録
		Monster[] monster = init();

		//登録数値のチェック
		if (!check(monster)) {
			System.out.println("試合を開始出来ません");
			return;
		}

		for (Monster mon : monster) {
			System.out.println(mon);
		}

		judgeOrder(monster);
		System.out.println(monster[0].getName() + "の先制です。");
		//バトル開始
		int roop = 0;
		while (true) {
			//roopが偶数の時
			if (roop % 2 == 0) {
				//[0]の攻撃
				System.out.println(monster[0].getName() + "の攻撃");
				int attack = monster[0].Attack(monster[1].getType());
				//[1]の反応
				if (monster[1].isHit()) {
					int damage = monster[1].Defense(attack);
					//かわした時と受けた時
					if (damage <= 0) {
						System.out.println(monster[1].getName() + "は攻撃をかわした！");
					} else {
						System.out.println(monster[1].getName() + "は" + damage + "ダメージを受けた！");
					}
				}
				//roopが奇数の時
			} else {
				//[1]の攻撃
				System.out.println(monster[1].getName() + "の攻撃");
				int attack = monster[1].Attack(monster[0].getType());
				//[0]の反応
				if (monster[0].isHit()) {
					int damage = monster[0].Defense(attack);
					//かわした時と受けた時
					if (damage <= 0) {
						System.out.println(monster[0].getName() + "は攻撃をかわした！");
					} else {
						System.out.println(monster[0].getName() + "は" + damage + "ダメージを受けた！");
					}
				}

			}
			//[0]が倒れた時
			if (monster[0].isSurvive()) {
			} else {
				System.out.print(monster[0].getName());
				System.out.println("は力尽きた");
				System.out.print(monster[1].getName());
				System.out.println("の勝利！");
				break;
			}
			//[1]が倒れた時
			if (monster[1].isSurvive()) {
			} else {
				System.out.print(monster[1].getName());
				System.out.println("は力尽きた");
				System.out.print(monster[0].getName());
				System.out.println("の勝利！");
				break;
			}
			roop++;
		}

	}

	private static Monster[] init() {
		System.out.println("お互いのモンスターを登録します。");
		//配列を用意
		Monster[] monster = new Monster[2];

		try {
			Monster mon = null;
			for (int i = 0; i <= 1; i++) {
				//属性の登録
				System.out.println("属性の数字(半角)を選んでください[1：赤、2：青、3：緑]");
				BufferedReader brt = new BufferedReader(new InputStreamReader(System.in));
				String typ = brt.readLine();
				//Stringをintへ変換
				int type = Integer.parseInt(typ);

				System.out.println("属性を" + type + "にしました");

				//名前の登録
				System.out.println("名前を登録してください");
				BufferedReader brn = new BufferedReader(new InputStreamReader(System.in));
				String name = brn.readLine();

				System.out.println("名前を" + name + "にしました。");

				//パラメーター設定
				System.out.println("体力・攻撃力・守備力・素早さを合計が100になるように設定してください");
				//体力設定
				BufferedReader brhp = new BufferedReader(new InputStreamReader(System.in));
				String h = brhp.readLine();
				int hp = Integer.parseInt(h);
				//攻撃力設定
				BufferedReader brof = new BufferedReader(new InputStreamReader(System.in));
				String of = brof.readLine();
				int offense = Integer.parseInt(of);
				//守備力
				BufferedReader brdf = new BufferedReader(new InputStreamReader(System.in));
				String df = brdf.readLine();
				int defense = Integer.parseInt(df);
				//素早さ
				BufferedReader brq = new BufferedReader(new InputStreamReader(System.in));
				String q = brq.readLine();
				int quickly = Integer.parseInt(q);

				//タイプによってモンスターを生成する
				if (type == 1) {
					RedMonster red = new RedMonster(name, hp, offense, defense, quickly);
					mon = red;
				}
				if (type == 2) {
					BlueMonster blue = new BlueMonster(name, hp, offense, defense, quickly);
					mon = blue;
				}
				if (type == 3) {
					GreenMonster green = new GreenMonster(name, hp, offense, defense, quickly);
					mon = green;
				}
				//できたモンスターを用意した配列に入れる
				monster[i] = mon;

			}
		} catch (Exception e) {
		}
		return monster;

	}

	//能力値の判定
	private static boolean check(Monster[] monster) {
		for (Monster m : monster) {
			if (!m.isCheck()) {
				System.out.println(m.getName() + "の能力値が不正です。");
				return false;
			}
		}
		return true;
	}

	//先攻後攻を決める
	private static void judgeOrder(Monster[] monster) {
		Monster monster1 = monster[0];
		Monster monster2 = monster[1];
		//5分の1の確率で素早さ以外での先攻判定
		Random rand = new Random();
		int rnd = rand.nextInt(5);
		if (rnd != 0) {
			if (monster[0].getQuickly() < monster[1].getQuickly()) {
				Monster m1 = monster1;
				monster1 = monster2;
				monster2 = m1;

			}

		}
	}
}
