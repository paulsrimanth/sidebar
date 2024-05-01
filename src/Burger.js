import { useEffect, useState } from "react";
import "./burger.css";
function Burger() {
  const [isOpen, setIsOpen] = useState(false);
  const [Items, Setitems] = useState([]);
  const toggleMenu = () => {
    setIsOpen(!isOpen);
  };
  useEffect(() => {
    fetchelements();
  }, []);
  const renderCategories = (categories) => {
    return (
      <ul>
        {categories?.map((category) => (
          <li key={category.catId}>{category.childs}</li>
        ))}
      </ul>
    );
  };

  const toggleDropdown = (index) => {
    const updatedMenuItems = [...Items];
    updatedMenuItems[index].showDropdown =
      !updatedMenuItems[index].showDropdown;
    Setitems(updatedMenuItems);
  };

  async function fetchelements() {
    const elementsresponse = await fetch(
      "http://localhost:8080/getallelements"
    );
    const displayitems = await elementsresponse.json();
    console.log(displayitems);
    if (displayitems) {
      Setitems(displayitems);
    }
  }
  return (
    <div className="burger-menu">
      <div
        className={`burger-icon ${isOpen ? "open" : ""}`}
        onClick={toggleMenu}
      >
        <div className="line line1"></div>
        <div className="line line2"></div>
        <div className="line line3"></div>
      </div>
      <div
        className={`overlay ${isOpen ? "open" : ""}`}
        onClick={toggleMenu}
      ></div>
      <div className={`menu-items ${isOpen ? "open" : ""}`}>
        <ul>
          {Items.map((menuItem, index) => (
            <li key={menuItem.id}>
              <div onClick={() => toggleDropdown(index)}>
                {menuItem.element}

                <div
                  className={`arrow ${menuItem.showDropdown ? "open" : ""}`}
                />
              </div>
              {menuItem.categories.length > 0 && (
                <div
                  className={`dropdown ${
                    menuItem.showDropdown ? "active" : ""
                  }`}
                >
                  <ul>
                    {menuItem.categories?.map((category) => (
                      <li key={category.catId}>{category.childs}</li>
                    ))}
                  </ul>
                </div>
              )}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default Burger;
