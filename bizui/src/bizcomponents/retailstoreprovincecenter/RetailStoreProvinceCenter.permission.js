

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
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

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (retailStoreProvinceCenter,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreProvinceCenter.id}</Description> 
<Description term="名称">{retailStoreProvinceCenter.name}</Description> 
<Description term="成立">{ moment(retailStoreProvinceCenter.founded).format('YYYY-MM-DD')}</Description> 
<Description term="最后更新时间">{ moment(retailStoreProvinceCenter.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
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
    const  retailStoreProvinceCenter = this.props.retailStoreProvinceCenter
    const { id,displayName, provinceCenterDepartmentCount, provinceCenterEmployeeCount, retailStoreCityServiceCenterCount } = retailStoreProvinceCenter
    const  returnURL = `/retailStoreProvinceCenter/${id}/dashboard`
    const cardsData = {cardsName:"双链小超省中心",cardsFor: "retailStoreProvinceCenter",cardsSource: retailStoreProvinceCenter,displayName,returnURL,
  		subItems: [
{name: 'provinceCenterDepartmentList', displayName:'省中心',type:'provinceCenterDepartment',count:provinceCenterDepartmentCount,addFunction: true, role: 'provinceCenterDepartment', data: retailStoreProvinceCenter.provinceCenterDepartmentList},
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
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

