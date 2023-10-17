import { Suspense, lazy } from 'react';
import { createRoutesFromElements, Route, Outlet } from 'react-router';
import LoadingScreen from './pages/loading/LoadingScreen';
import Battle from './pages/battle/Battle';

const Loadable = (Component: any) => (props: JSX.IntrinsicAttributes) =>
  (
    <Suspense fallback={<LoadingScreen />}>
      <Component {...props} />
    </Suspense>
  );

const HomePage = Loadable(lazy(() => import('./pages/home/HomePage')));
const PokemonPage = Loadable(lazy(() => import('./pages/pokemon/PokemonPage')));
const PokedexPage = Loadable(lazy(() => import('./pages/pokedex/PokedexPage')));
const ErrorPage = Loadable(lazy(() => import('./pages/error/ErrorPage')));

let routes = createRoutesFromElements(
    <Route errorElement={<ErrorPage />}>
        <Route path="/" element={<HomePage />} />
        <Route path="/pokedex" element={<PokedexPage />} />
        <Route path="/pokedex/:pokemon" element={<PokemonPage />} loader={(params: any) => {return params}}/>
        <Route path="/battle" element={<Battle />} />
    </Route>
)

export default routes;