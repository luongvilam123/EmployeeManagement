import React from 'react';
import "./congvieclist.scss";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import ChamCongDataTable from "../../components/datatable/ChamCongTable";

const ChamCongList = () =>
{
    return (
        <div className="list">
            <Sidebar/>
            <div className="listContainer">
                <Navbar/>

                <ChamCongDataTable/>

            </div>
        </div>
    );
};

export default ChamCongList;