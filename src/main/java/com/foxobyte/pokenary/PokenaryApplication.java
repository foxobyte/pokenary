package com.foxobyte.pokenary;

import com.foxobyte.pokenary.constants.Generation;
import com.foxobyte.pokenary.constants.MoveCategory;
import com.foxobyte.pokenary.constants.Type;
import com.foxobyte.pokenary.dao.Game;
import com.foxobyte.pokenary.dao.Move;
import com.foxobyte.pokenary.dao.pokemon.EffortValues;
import com.foxobyte.pokenary.dao.pokemon.Pokemon;
import com.foxobyte.pokenary.dao.pokemon.WildPokemon;
import org.hibernate.type.SortedSetType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static com.foxobyte.pokenary.util.StatsCalculator.calculatePokemonStatsWithDeterminantValues;
import static com.foxobyte.pokenary.util.RNGCalculator.*;

@SpringBootApplication
@EnableJpaRepositories
public class PokenaryApplication {

	public static void main(String[] args) {
//		Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", List.of(Type.GRASS, Type.POISON), 45, 49, 49, 65, 65, 45);
//		WildPokemon bulbasaur1 = new WildPokemon(bulbasaur, 100, generateDeterminantValues());
//		WildPokemon bulbasaur2 = new WildPokemon(bulbasaur, 50, generateDeterminantValues());
//
//		Move move = new Move();
//		move.setCategory(MoveCategory.SPECIAL);
//		move.setHighCrit(false);
//		move.setPower(120);
//		move.setType(Type.GRASS);
//		calculatePokemonStatsWithDeterminantValues(bulbasaur1);
//		calculatePokemonStatsWithDeterminantValues(bulbasaur2);
//
////		type.getEffectiveness().get(Type.NORMAL.getName());
//		Game game = new Game();
//		Generation.ONE.calculateDamage(bulbasaur1, bulbasaur2, move, game);
//		Generation.ONE.calculateDamage(bulbasaur1, bulbasaur2, move, game);
//		Generation.ONE.calculateDamage(bulbasaur1, bulbasaur2, move, game);
//		Generation.ONE.calculateDamage(bulbasaur1, bulbasaur2, move, game);
//		Generation.ONE.calculateDamage(bulbasaur1, bulbasaur2, move, game);
//		EffortValues effortValues = new EffortValues(0L, 0, 0, 0, 0, 0, 0);
//		for (int i = 0; i < 100; i++) {
//			effortValues.addHp(3);
//		}
//
//		for (int i = 0; i < 100; i++) {
//			effortValues.addSpeed(3);
//		}
//
//		for (int i = 0; i < 100; i++) {
//			effortValues.addDefense(3);
//		}

		SpringApplication.run(PokenaryApplication.class, args);
	}

}
