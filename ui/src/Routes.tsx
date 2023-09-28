import { Suspense, lazy } from 'react';
import { RouteObject, createRoutesFromElements, Route, Outlet } from 'react-router';
import LoadingScreen from './pages/loading/LoadingScreen';

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
        <Route path="/pokedex/:pokemon" element={<PokemonPage />} loader={(params) => {return params}}/>
    </Route>
)

export default routes;