

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import GlobalComponents from '../../custcomponents';
import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreProvinceCenter.profile.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf, defaultRenderSettingList,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf

const internalRenderSettingList = defaultRenderSettingList

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}

const internalSummaryOf = (item, targetComponents)=>{
	
	return GlobalComponents.RetailStoreProvinceCenterBase.renderItemOfList(item, targetComponents)

}



class RetailStoreProvinceCenterProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreProvinceCenter = this.props.retailStoreProvinceCenter;
    const { id,displayName, provinceCenterDepartmentCount, provinceCenterEmployeeCount, retailStoreCityServiceCenterCount } = retailStoreProvinceCenter

    const cardsData = {cardsName:"双链小超省中心",cardsFor: "retailStoreProvinceCenter",cardsSource: retailStoreProvinceCenter,
  		subItems: [
{name: 'provinceCenterDepartmentList', displayName:'省中心',type:'provinceCenterDepartment',count:provinceCenterDepartmentCount,addFunction: true, role: 'provinceCenterDepartment',  renderItem: GlobalComponents.ProvinceCenterDepartmentBase.renderItemOfList},
     
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
   
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderSettingList = this.props.renderSettingList || internalRenderSettingList
    
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {renderSettingList(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  retailStoreProvinceCenter: state._retailStoreProvinceCenter,
}))(Form.create()(RetailStoreProvinceCenterProfile))

