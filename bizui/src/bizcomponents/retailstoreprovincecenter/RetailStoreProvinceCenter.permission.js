

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreProvinceCenter.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStoreProvinceCenter,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{retailStoreProvinceCenter.id}</Description> 
<Description term="Name">{retailStoreProvinceCenter.name}</Description> 
<Description term="Founded">{ moment(retailStoreProvinceCenter.founded).format('YYYY-MM-DD')}</Description> 
<Description term="Last Update Time">{ moment(retailStoreProvinceCenter.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreProvinceCenter => {
  const {RetailStoreProvinceCenterBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreProvinceCenter}  targetObjectMeta={RetailStoreProvinceCenterBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreProvinceCenterPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreProvinceCenter = this.props.retailStoreProvinceCenter;
    const { id,displayName, provinceCenterDepartmentCount, provinceCenterEmployeeCount, retailStoreCityServiceCenterCount } = retailStoreProvinceCenter
    const cardsData = {cardsName:"Retail Store Province Center",cardsFor: "retailStoreProvinceCenter",cardsSource: retailStoreProvinceCenter,
  		subItems: [
{name: 'provinceCenterDepartmentList', displayName:'Province Center Department',type:'provinceCenterDepartment',count:provinceCenterDepartmentCount,addFunction: true, role: 'provinceCenterDepartment', data: retailStoreProvinceCenter.provinceCenterDepartmentList},
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  retailStoreProvinceCenter: state._retailStoreProvinceCenter,
}))(Form.create()(RetailStoreProvinceCenterPermission))

