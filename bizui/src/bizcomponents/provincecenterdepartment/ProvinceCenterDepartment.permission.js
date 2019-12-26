

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ProvinceCenterDepartment.profile.less'
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
const internalSummaryOf = (provinceCenterDepartment,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{provinceCenterDepartment.id}</Description> 
<Description term="名称">{provinceCenterDepartment.name}</Description> 
<Description term="成立">{ moment(provinceCenterDepartment.founded).format('YYYY-MM-DD')}</Description> 
<<<<<<< HEAD
<Description term="经理">{provinceCenterDepartment.manager}</Description> 
=======
<Description term="经理的名字">{provinceCenterDepartment.managerName}</Description> 
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
	
      </DescriptionList>
	)
}


const renderPermissionSetting = provinceCenterDepartment => {
  const {ProvinceCenterDepartmentBase} = GlobalComponents
  return <PermissionSetting targetObject={provinceCenterDepartment}  targetObjectMeta={ProvinceCenterDepartmentBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ProvinceCenterDepartmentPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  provinceCenterDepartment = this.props.provinceCenterDepartment
    const { id,displayName, provinceCenterEmployeeCount } = provinceCenterDepartment
    const  returnURL = `/provinceCenterDepartment/${id}/dashboard`
    const cardsData = {cardsName:"省中心",cardsFor: "provinceCenterDepartment",cardsSource: provinceCenterDepartment,displayName,returnURL,
  		subItems: [
    
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
  provinceCenterDepartment: state._provinceCenterDepartment,
}))(Form.create()(ProvinceCenterDepartmentPermission))

