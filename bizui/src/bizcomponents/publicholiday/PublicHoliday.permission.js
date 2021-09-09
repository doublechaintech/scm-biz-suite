

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './PublicHoliday.profile.less'
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
const internalSummaryOf = (publicHoliday,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{publicHoliday.id}</Description> 
<Description term="代码">{publicHoliday.code}</Description> 
<Description term="名称">{publicHoliday.name}</Description> 
<Description term="描述">{publicHoliday.description}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = publicHoliday => {
  const {PublicHolidayBase} = GlobalComponents
  return <PermissionSetting targetObject={publicHoliday}  targetObjectMeta={PublicHolidayBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class PublicHolidayPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  publicHoliday = this.props.publicHoliday
    const { id,displayName,  } = publicHoliday
    const  returnURL = `/publicHoliday/${id}/workbench`
    const cardsData = {cardsName:"公共假日",cardsFor: "publicHoliday",cardsSource: publicHoliday,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  publicHoliday: state._publicHoliday,
}))(Form.create()(PublicHolidayPermission))

