<template>
	<div class="diy_list page_vaccine_information" id="vaccine_information_list">
		<div class="warp">
			<div class="container diy_list_container">
				<div class="diy_list_title">
					<div class="col">
						<span class="title">疫苗信息列表</span>
					</div>
				</div>
				<div class="row diy_list_search">
					<div class="col">
						<!-- 搜索栏 -->
						<div class="view">							
							<span class="diy_list_search_title">关键字搜索：</span>
							<b-form-input size="sm" class="mr-sm-2" placeholder="疫苗类型搜索" v-model="query['vaccine_type']" />
							<b-form-input size="sm" class="mr-sm-2" placeholder="疫苗名称搜索" v-model="query['vaccine_name']" />
							<b-form-input size="sm" class="mr-sm-2" placeholder="疫苗出产地搜索" v-model="query['vaccine_producing_area']" />
							<b-button size="sm" @click="search()" >
								<b-icon icon="search"/>
							</b-button>
						</div>
						<!-- /搜索栏 -->
					</div>
				</div>
				<div class="diy_list_select_box">
					<span class="diy_list_select_title">下拉搜索：</span>
						<div class="diy_list_dropdown_box">
						<div class="col">
							<!-- 筛选 -->
							<div class="view">
								<b-dropdown :text="title" variant="outline-dark" left>
									<b-dropdown-item @click="filter_set('全部','vaccine_producing_area')">全部</b-dropdown-item>
										<b-dropdown-item v-for="(o,i) in list_vaccine_producing_area" @click="filter_set(o,'vaccine_producing_area')" >
										{{ o }}
										</b-dropdown-item>
								</b-dropdown>
							</div>
							<!-- /筛选 -->
						</div>
					</div>
					<div class="diy_list_sort_box">
						<div class="col">
							<!-- 排序 -->
							<div class="view">
								<b-dropdown text="排序" variant="outline-dark" left>
										<b-dropdown-item v-for="(o, i) in list_sort" :key="i" @click="set_sort(o)" >
												{{ o.name }}
										</b-dropdown-item>
								</b-dropdown>
							</div>
							<!--/排序 -->
						</div>
					</div>
				</div>
				<div class="row diy_list_box">
					<div class="col">
						<!-- 列表 -->
						<list_vaccine_information :list="list" />
						<!-- /列表 -->
					</div>
				</div>
				<div class="row diy_list_page_box">
					<div class="col overflow-auto flex_cc">
						<!-- 分页器 -->
						<diy_pager v-model="query['page']" :size="query['size']" :count="count" v-on:toPage="toPage" v-on:toSize="toSize" ></diy_pager>
						<!-- /分页器 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import list_vaccine_information from "@/components/diy/list_vaccine_information.vue";
	import diy_pager from "@/components/diy/diy_pager";
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		components: {
			diy_pager,
			list_vaccine_information
		},
		data() {
			return {
				url_get_list: "~/api/vaccine_information/get_list?like=0",

				// 查询条件
				query: {
					keyword: "",
					page: 1,
					size: 10,
					"vaccine_type": "", // 疫苗类型
					"vaccine_name": "", // 疫苗名称
					"vaccine_producing_area": "", // 疫苗出产地
				},

				// 排序内容
				list_sort: [{
						name: "创建时间从高到低",
						value: "`create_time` desc",
					},
					{
						name: "创建时间从低到高",
						value: "`create_time` asc",
					},
					{
						name: "更新时间从高到低",
						value: "`update_time` desc",
					},
					{
						name: "更新时间从低到高",
						value: "`update_time` asc",
					},
					{
						name: "疫苗类型正序",
						value: "`vaccine_type` asc",
					},
					{
						name: "疫苗类型倒序",
						value: "`vaccine_type` desc",
					},
					{
						name: "疫苗名称正序",
						value: "`vaccine_name` asc",
					},
					{
						name: "疫苗名称倒序",
						value: "`vaccine_name` desc",
					},
					{
						name: "疫苗出产地正序",
						value: "`vaccine_producing_area` asc",
					},
					{
						name: "疫苗出产地倒序",
						value: "`vaccine_producing_area` desc",
					},
				],
				// 疫苗出产地列表
				"list_vaccine_producing_area": ['进口','国产'],
			}
		},
		methods: {
			/**
			 * 筛选选择
			 */
			filter_set(o,key) {
			    if (o == "全部") {
			        this.query[key] = "";
			    } else {
			        this.query[key] = o;
			    }
			    this.search();
			},

			/**
			 * 排序
			 */
			set_sort(o) {
			    this.query.orderby = o.value;
			    this.search();
			},

			/**
			 * 筛选
			 */
			filter_vaccine_producing_area(o) {
				if (o == "全部") {
					this.query["vaccine_producing_area"] = "";
				} else {
					this.query["vaccine_producing_area"] = o;
				}
				this.search();
			},

			/**
			 * 重置
			 */
			reset() {
				this.query.vaccine_type = ""
				this.query.vaccine_name = ""
				this.query.vaccine_producing_area = ""
				this.search();
			},

			// 返回条数
			toSize(i){
				this.query.size = i;
				this.first();
			},

			// 返回页数
			toPage(i){
				this.query.page = i;
				this.first();
			},
		},
		computed: {
		},
		created() {
		}
	}
</script>

<style>
</style>
