import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { PrimeReactProvider } from "primereact/api";
import App from "./App.jsx";
import "primereact/resources/themes/viva-light/theme.css";
import "primeicons/primeicons.css";
import "primereact/resources/primereact.min.css";
import "primeflex/primeflex.css";
import "./index.css";
import { BrowserRouter } from "react-router-dom";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <PrimeReactProvider>
      <BrowserRouter>
        <App />
      </BrowserRouter>
    </PrimeReactProvider>
  </StrictMode>
);
