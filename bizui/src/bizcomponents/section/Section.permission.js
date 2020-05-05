

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Section.profile.less'
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
const internalSummaryOf = (section,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{section.id}</Description> 
<Description term="头衔">{section.title}</Description> 
<Description term="短暂的">{section.brief}</Description> 
<Description term="图标"><ImagePreview imageTitle="图标" imageLocation={section.icon}/></Description> 
<Description term="顺序">{section.displayOrder}</Description> 
<Description term="视图组">{section.viewGroup}</Description> 
<Description term="链接网址">{section.linkToUrl}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = section => {
  const {SectionBase} = GlobalComponents
  return <PermissionSetting targetObject={section}  targetObjectMeta={SectionBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SectionPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  section = this.props.section
    const { id,displayName,  } = section
    const  returnURL = `/section/${id}/dashboard`
    const cardsData = {cardsName:"板块",cardsFor: "section",cardsSource: section,displayName,returnURL,
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
  section: state._section,
}))(Form.create()(SectionPermission))

